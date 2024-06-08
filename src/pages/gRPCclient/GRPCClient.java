package pages.gRPCclient;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.LongStream;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import ru.yandex.travel.search.SearchRequestV1;
import ru.yandex.travel.search.TravelSearchV1Grpc;

import static java.util.concurrent.TimeUnit.MINUTES;

@Log4j2
public class GRPCClient {
    public static void main(String... args) {
        new GRPCClient().client();
    }

    final AtomicInteger counter = new AtomicInteger();
    final int numberOfRequests = 1_000_000;
    final int parallelClients = 2048;


    private void blockingStubClient(List<Stats> stats, Channel channel) {
        final var travelSearchAPI = TravelSearchV1Grpc.newBlockingStub(channel);
        final var countSent = new AtomicInteger();
        final var countReceived = new AtomicInteger();
        log.info("Starting to send requests");
        final var latch = new java.util.concurrent.CountDownLatch(numberOfRequests);
        final var threads = new ArrayList<Thread>();
        for (int threadCount = 0; threadCount < parallelClients; threadCount++) {
            final var thread = new Thread(() -> {
                while (countSent.getAndIncrement() < numberOfRequests) {
                    try {
                        final var stat = new Stats();
                        stat.reqID = counter.incrementAndGet();
                        stat.timeStart = System.nanoTime();
                        final var searchResult = travelSearchAPI.search(SearchRequestV1
                                .newBuilder()
                                .setReqID(stat.reqID)
                                .build());
                        stat.timeStop = System.nanoTime();
                        stat.rspID = searchResult.getRspID();
                        stat.threadName = searchResult.getThreadName();
                        if (stat.reqID > numberOfRequests / 100) {
                            stats.add(stat);
                        }
                    } finally {
                        countReceived.incrementAndGet();
                        latch.countDown();
                    }
                }
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        new Thread(() -> {
            while (countReceived.get() < numberOfRequests) {
                log.info("{}%\t{}%",
                        (int) ((double) countSent.get() / (double) numberOfRequests * 100.0),
                        (int) ((double) countReceived.get() / (double) numberOfRequests * 100.0));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Done");
    }

    @SneakyThrows
    private void client() {

        final var channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .directExecutor()
                .build();
        List<Stats> stats = Collections.synchronizedList(new ArrayList<>());
        blockingStubClient(stats, channel);
        buildResponseTimeDistribution(stats);
        buildThreadNameDistribution(stats);

        channel.shutdownNow();
        channel.awaitTermination(1, MINUTES);
        log.info("Shut down");
    }

    private void buildThreadNameDistribution(List<Stats> stats) {
        final var threadNames = new HashMap<String, Long>();
        for (Stats s : stats) {
            threadNames.compute(s.threadName, (threadName, counter) -> {
                if (counter == null) {
                    return 1L;
                } else {
                    return counter + 1;
                }
            });
        }
        if (threadNames.size() > 8) {
            log.info("Server used {} threads", threadNames.size());
            return;
        }
        for (var t : threadNames.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList()) {
            log.info(t.getKey() + "\t" + t.getValue());
        }
    }

    static void buildResponseTimeDistribution(List<Stats> stats) {
        final var values = stats.stream().map(s -> s.timeStop - s.timeStart).sorted().toList();
        final var minimum = 5_000_000;
        final long maximum = 1 << 25;
        final var diff = maximum - minimum;
        final var numberOfSamples = 100;
        final var sampleWidth = diff / numberOfSamples;
        final var samples = LongStream.iterate(minimum, (l) -> l < maximum,
                (l) -> l + sampleWidth).boxed().sorted().toList();

        final Function<Long, Long> findNearestSample =
                (Long val) -> samples.stream().min(Comparator.comparing(l -> Math.abs(val - l))).get();

        final var distribution = new ConcurrentHashMap<Long, Double>();

        values.forEach(responseTime -> distribution.compute(findNearestSample.apply(responseTime), (key, curValue) -> {
            final double contribution = 1;
            if (curValue == null || curValue.isInfinite() || curValue.isNaN()) {
                return contribution;
            } else {
                return curValue + contribution;
            }
        }));
        try (final var printer = new PrintStream(new FileOutputStream("response distribution.txt"))) {
            samples.forEach(s -> printer.printf("%.3f\t%s%n", (double) s / 1E6, distribution.getOrDefault(s, 0.0)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Stats {
    int reqID;
    int rspID;
    /**
     * nanoseconds
     */
    long timeStart;
    /**
     * nanoseconds
     */
    long timeStop;
    String threadName;
}
