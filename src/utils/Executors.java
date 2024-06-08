package utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class Executors {
    final static AtomicInteger namedCachedGlobal = new AtomicInteger();
    final static AtomicInteger namedFixed = new AtomicInteger();

    private Executors() {
    }

    public static ExecutorService namedCached(String name) {
        var groupCounter = namedCachedGlobal.incrementAndGet();
        var counter = new AtomicInteger();
        return java.util.concurrent.Executors.newCachedThreadPool((r) ->
                new Thread(r, "%s-%d-%d".formatted(name, groupCounter, counter.incrementAndGet())));
    }

    public static ExecutorService namedFixed(String name, int nThreads) {
        var groupCounter = namedFixed.incrementAndGet();
        var counter = new AtomicInteger();
        return java.util.concurrent.Executors.newFixedThreadPool(nThreads, (r) ->
                new Thread(r, "%s-%d-%d".formatted(name, groupCounter, counter.incrementAndGet())));
    }
}
