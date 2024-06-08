package ru.yandex.travel.search;// Generated by the protocol buffer compiler.  DO NOT EDIT!

/**
 * Protobuf type {@code search.SearchRequestV1}
 */
public final class SearchRequestV1 extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:search.SearchRequestV1)
    SearchRequestV1OrBuilder {
private static final long serialVersionUID = 0L;
  // Use SearchRequestV1.newBuilder() to construct.
  private SearchRequestV1(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SearchRequestV1() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new SearchRequestV1();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.yandex.travel.search.Search.internal_static_search_SearchRequestV1_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.yandex.travel.search.Search.internal_static_search_SearchRequestV1_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.yandex.travel.search.SearchRequestV1.class, ru.yandex.travel.search.SearchRequestV1.Builder.class);
  }

  public static final int REQID_FIELD_NUMBER = 1;
  private int reqID_ = 0;
  /**
   * <code>int32 reqID = 1;</code>
   * @return The reqID.
   */
  @Override
  public int getReqID() {
    return reqID_;
  }

  public static final int DELAY_FIELD_NUMBER = 2;
  private int delay_ = 0;
  /**
   * <code>uint32 delay = 2;</code>
   * @return The delay.
   */
  @Override
  public int getDelay() {
    return delay_;
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (reqID_ != 0) {
      output.writeInt32(1, reqID_);
    }
    if (delay_ != 0) {
      output.writeUInt32(2, delay_);
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (reqID_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, reqID_);
    }
    if (delay_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, delay_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ru.yandex.travel.search.SearchRequestV1)) {
      return super.equals(obj);
    }
    ru.yandex.travel.search.SearchRequestV1 other = (ru.yandex.travel.search.SearchRequestV1) obj;

    if (getReqID()
        != other.getReqID()) return false;
    if (getDelay()
        != other.getDelay()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + REQID_FIELD_NUMBER;
    hash = (53 * hash) + getReqID();
    hash = (37 * hash) + DELAY_FIELD_NUMBER;
    hash = (53 * hash) + getDelay();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.yandex.travel.search.SearchRequestV1 parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ru.yandex.travel.search.SearchRequestV1 prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code search.SearchRequestV1}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:search.SearchRequestV1)
      ru.yandex.travel.search.SearchRequestV1OrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.yandex.travel.search.Search.internal_static_search_SearchRequestV1_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.yandex.travel.search.Search.internal_static_search_SearchRequestV1_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.yandex.travel.search.SearchRequestV1.class, ru.yandex.travel.search.SearchRequestV1.Builder.class);
    }

    // Construct using ru.yandex.travel.search.SearchRequestV1.newBuilder()
    private Builder() {

    }

    private Builder(
        BuilderParent parent) {
      super(parent);

    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      reqID_ = 0;
      delay_ = 0;
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.yandex.travel.search.Search.internal_static_search_SearchRequestV1_descriptor;
    }

    @Override
    public ru.yandex.travel.search.SearchRequestV1 getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    @Override
    public ru.yandex.travel.search.SearchRequestV1 build() {
      ru.yandex.travel.search.SearchRequestV1 result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public ru.yandex.travel.search.SearchRequestV1 buildPartial() {
      ru.yandex.travel.search.SearchRequestV1 result = new ru.yandex.travel.search.SearchRequestV1(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(ru.yandex.travel.search.SearchRequestV1 result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.reqID_ = reqID_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.delay_ = delay_;
      }
    }

    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ru.yandex.travel.search.SearchRequestV1) {
        return mergeFrom((ru.yandex.travel.search.SearchRequestV1)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.yandex.travel.search.SearchRequestV1 other) {
      if (other == getDefaultInstance()) return this;
      if (other.getReqID() != 0) {
        setReqID(other.getReqID());
      }
      if (other.getDelay() != 0) {
        setDelay(other.getDelay());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              reqID_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              delay_ = input.readUInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int reqID_ ;
    /**
     * <code>int32 reqID = 1;</code>
     * @return The reqID.
     */
    @Override
    public int getReqID() {
      return reqID_;
    }
    /**
     * <code>int32 reqID = 1;</code>
     * @param value The reqID to set.
     * @return This builder for chaining.
     */
    public Builder setReqID(int value) {

      reqID_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 reqID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearReqID() {
      bitField0_ = (bitField0_ & ~0x00000001);
      reqID_ = 0;
      onChanged();
      return this;
    }

    private int delay_ ;
    /**
     * <code>uint32 delay = 2;</code>
     * @return The delay.
     */
    @Override
    public int getDelay() {
      return delay_;
    }
    /**
     * <code>uint32 delay = 2;</code>
     * @param value The delay to set.
     * @return This builder for chaining.
     */
    public Builder setDelay(int value) {

      delay_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 delay = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDelay() {
      bitField0_ = (bitField0_ & ~0x00000002);
      delay_ = 0;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:search.SearchRequestV1)
  }

  // @@protoc_insertion_point(class_scope:search.SearchRequestV1)
  private static final ru.yandex.travel.search.SearchRequestV1 DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.yandex.travel.search.SearchRequestV1();
  }

  public static ru.yandex.travel.search.SearchRequestV1 getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SearchRequestV1>
      PARSER = new com.google.protobuf.AbstractParser<SearchRequestV1>() {
    @Override
    public SearchRequestV1 parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<SearchRequestV1> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<SearchRequestV1> getParserForType() {
    return PARSER;
  }

  @Override
  public ru.yandex.travel.search.SearchRequestV1 getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

