// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: device.proto

package com.bruce.grpc.lib.device;

/**
 * Protobuf type {@code device.deviceFix}
 */
public  final class deviceFix extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:device.deviceFix)
    deviceFixOrBuilder {
private static final long serialVersionUID = 0L;
  // Use deviceFix.newBuilder() to construct.
  private deviceFix(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private deviceFix() {
    id_ = "";
    serialNum_ = "";
    userNum_ = "";
    status_ = 0;
    type_ = 0;
    address_ = "";
    createtime_ = "";
    updatetime_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private deviceFix(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            serialNum_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            userNum_ = s;
            break;
          }
          case 32: {

            status_ = input.readInt32();
            break;
          }
          case 40: {

            type_ = input.readInt32();
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            address_ = s;
            break;
          }
          case 58: {
            java.lang.String s = input.readStringRequireUtf8();

            createtime_ = s;
            break;
          }
          case 66: {
            java.lang.String s = input.readStringRequireUtf8();

            updatetime_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.bruce.grpc.lib.device.DeviceFixProto.internal_static_device_deviceFix_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.bruce.grpc.lib.device.DeviceFixProto.internal_static_device_deviceFix_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.bruce.grpc.lib.device.deviceFix.class, com.bruce.grpc.lib.device.deviceFix.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object id_;
  /**
   * <code>string id = 1;</code>
   */
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SERIALNUM_FIELD_NUMBER = 2;
  private volatile java.lang.Object serialNum_;
  /**
   * <code>string serialNum = 2;</code>
   */
  public java.lang.String getSerialNum() {
    java.lang.Object ref = serialNum_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      serialNum_ = s;
      return s;
    }
  }
  /**
   * <code>string serialNum = 2;</code>
   */
  public com.google.protobuf.ByteString
      getSerialNumBytes() {
    java.lang.Object ref = serialNum_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      serialNum_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERNUM_FIELD_NUMBER = 3;
  private volatile java.lang.Object userNum_;
  /**
   * <code>string userNum = 3;</code>
   */
  public java.lang.String getUserNum() {
    java.lang.Object ref = userNum_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userNum_ = s;
      return s;
    }
  }
  /**
   * <code>string userNum = 3;</code>
   */
  public com.google.protobuf.ByteString
      getUserNumBytes() {
    java.lang.Object ref = userNum_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userNum_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUS_FIELD_NUMBER = 4;
  private int status_;
  /**
   * <code>int32 status = 4;</code>
   */
  public int getStatus() {
    return status_;
  }

  public static final int TYPE_FIELD_NUMBER = 5;
  private int type_;
  /**
   * <code>int32 type = 5;</code>
   */
  public int getType() {
    return type_;
  }

  public static final int ADDRESS_FIELD_NUMBER = 6;
  private volatile java.lang.Object address_;
  /**
   * <code>string address = 6;</code>
   */
  public java.lang.String getAddress() {
    java.lang.Object ref = address_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      address_ = s;
      return s;
    }
  }
  /**
   * <code>string address = 6;</code>
   */
  public com.google.protobuf.ByteString
      getAddressBytes() {
    java.lang.Object ref = address_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      address_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CREATETIME_FIELD_NUMBER = 7;
  private volatile java.lang.Object createtime_;
  /**
   * <code>string createtime = 7;</code>
   */
  public java.lang.String getCreatetime() {
    java.lang.Object ref = createtime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      createtime_ = s;
      return s;
    }
  }
  /**
   * <code>string createtime = 7;</code>
   */
  public com.google.protobuf.ByteString
      getCreatetimeBytes() {
    java.lang.Object ref = createtime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      createtime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int UPDATETIME_FIELD_NUMBER = 8;
  private volatile java.lang.Object updatetime_;
  /**
   * <code>string updatetime = 8;</code>
   */
  public java.lang.String getUpdatetime() {
    java.lang.Object ref = updatetime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      updatetime_ = s;
      return s;
    }
  }
  /**
   * <code>string updatetime = 8;</code>
   */
  public com.google.protobuf.ByteString
      getUpdatetimeBytes() {
    java.lang.Object ref = updatetime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      updatetime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
    }
    if (!getSerialNumBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, serialNum_);
    }
    if (!getUserNumBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, userNum_);
    }
    if (status_ != 0) {
      output.writeInt32(4, status_);
    }
    if (type_ != 0) {
      output.writeInt32(5, type_);
    }
    if (!getAddressBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, address_);
    }
    if (!getCreatetimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, createtime_);
    }
    if (!getUpdatetimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 8, updatetime_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
    }
    if (!getSerialNumBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, serialNum_);
    }
    if (!getUserNumBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, userNum_);
    }
    if (status_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, status_);
    }
    if (type_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, type_);
    }
    if (!getAddressBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, address_);
    }
    if (!getCreatetimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, createtime_);
    }
    if (!getUpdatetimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, updatetime_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.bruce.grpc.lib.device.deviceFix)) {
      return super.equals(obj);
    }
    com.bruce.grpc.lib.device.deviceFix other = (com.bruce.grpc.lib.device.deviceFix) obj;

    boolean result = true;
    result = result && getId()
        .equals(other.getId());
    result = result && getSerialNum()
        .equals(other.getSerialNum());
    result = result && getUserNum()
        .equals(other.getUserNum());
    result = result && (getStatus()
        == other.getStatus());
    result = result && (getType()
        == other.getType());
    result = result && getAddress()
        .equals(other.getAddress());
    result = result && getCreatetime()
        .equals(other.getCreatetime());
    result = result && getUpdatetime()
        .equals(other.getUpdatetime());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + SERIALNUM_FIELD_NUMBER;
    hash = (53 * hash) + getSerialNum().hashCode();
    hash = (37 * hash) + USERNUM_FIELD_NUMBER;
    hash = (53 * hash) + getUserNum().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + getStatus();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType();
    hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
    hash = (53 * hash) + getAddress().hashCode();
    hash = (37 * hash) + CREATETIME_FIELD_NUMBER;
    hash = (53 * hash) + getCreatetime().hashCode();
    hash = (37 * hash) + UPDATETIME_FIELD_NUMBER;
    hash = (53 * hash) + getUpdatetime().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.bruce.grpc.lib.device.deviceFix parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.bruce.grpc.lib.device.deviceFix parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.bruce.grpc.lib.device.deviceFix prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code device.deviceFix}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:device.deviceFix)
      com.bruce.grpc.lib.device.deviceFixOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.bruce.grpc.lib.device.DeviceFixProto.internal_static_device_deviceFix_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.bruce.grpc.lib.device.DeviceFixProto.internal_static_device_deviceFix_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.bruce.grpc.lib.device.deviceFix.class, com.bruce.grpc.lib.device.deviceFix.Builder.class);
    }

    // Construct using com.bruce.grpc.lib.device.deviceFix.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      id_ = "";

      serialNum_ = "";

      userNum_ = "";

      status_ = 0;

      type_ = 0;

      address_ = "";

      createtime_ = "";

      updatetime_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.bruce.grpc.lib.device.DeviceFixProto.internal_static_device_deviceFix_descriptor;
    }

    @java.lang.Override
    public com.bruce.grpc.lib.device.deviceFix getDefaultInstanceForType() {
      return com.bruce.grpc.lib.device.deviceFix.getDefaultInstance();
    }

    @java.lang.Override
    public com.bruce.grpc.lib.device.deviceFix build() {
      com.bruce.grpc.lib.device.deviceFix result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.bruce.grpc.lib.device.deviceFix buildPartial() {
      com.bruce.grpc.lib.device.deviceFix result = new com.bruce.grpc.lib.device.deviceFix(this);
      result.id_ = id_;
      result.serialNum_ = serialNum_;
      result.userNum_ = userNum_;
      result.status_ = status_;
      result.type_ = type_;
      result.address_ = address_;
      result.createtime_ = createtime_;
      result.updatetime_ = updatetime_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.bruce.grpc.lib.device.deviceFix) {
        return mergeFrom((com.bruce.grpc.lib.device.deviceFix)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.bruce.grpc.lib.device.deviceFix other) {
      if (other == com.bruce.grpc.lib.device.deviceFix.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (!other.getSerialNum().isEmpty()) {
        serialNum_ = other.serialNum_;
        onChanged();
      }
      if (!other.getUserNum().isEmpty()) {
        userNum_ = other.userNum_;
        onChanged();
      }
      if (other.getStatus() != 0) {
        setStatus(other.getStatus());
      }
      if (other.getType() != 0) {
        setType(other.getType());
      }
      if (!other.getAddress().isEmpty()) {
        address_ = other.address_;
        onChanged();
      }
      if (!other.getCreatetime().isEmpty()) {
        createtime_ = other.createtime_;
        onChanged();
      }
      if (!other.getUpdatetime().isEmpty()) {
        updatetime_ = other.updatetime_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.bruce.grpc.lib.device.deviceFix parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.bruce.grpc.lib.device.deviceFix) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 1;</code>
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      id_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object serialNum_ = "";
    /**
     * <code>string serialNum = 2;</code>
     */
    public java.lang.String getSerialNum() {
      java.lang.Object ref = serialNum_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        serialNum_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string serialNum = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSerialNumBytes() {
      java.lang.Object ref = serialNum_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serialNum_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string serialNum = 2;</code>
     */
    public Builder setSerialNum(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      serialNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string serialNum = 2;</code>
     */
    public Builder clearSerialNum() {
      
      serialNum_ = getDefaultInstance().getSerialNum();
      onChanged();
      return this;
    }
    /**
     * <code>string serialNum = 2;</code>
     */
    public Builder setSerialNumBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      serialNum_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object userNum_ = "";
    /**
     * <code>string userNum = 3;</code>
     */
    public java.lang.String getUserNum() {
      java.lang.Object ref = userNum_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userNum_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string userNum = 3;</code>
     */
    public com.google.protobuf.ByteString
        getUserNumBytes() {
      java.lang.Object ref = userNum_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userNum_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string userNum = 3;</code>
     */
    public Builder setUserNum(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string userNum = 3;</code>
     */
    public Builder clearUserNum() {
      
      userNum_ = getDefaultInstance().getUserNum();
      onChanged();
      return this;
    }
    /**
     * <code>string userNum = 3;</code>
     */
    public Builder setUserNumBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userNum_ = value;
      onChanged();
      return this;
    }

    private int status_ ;
    /**
     * <code>int32 status = 4;</code>
     */
    public int getStatus() {
      return status_;
    }
    /**
     * <code>int32 status = 4;</code>
     */
    public Builder setStatus(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 status = 4;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private int type_ ;
    /**
     * <code>int32 type = 5;</code>
     */
    public int getType() {
      return type_;
    }
    /**
     * <code>int32 type = 5;</code>
     */
    public Builder setType(int value) {
      
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 type = 5;</code>
     */
    public Builder clearType() {
      
      type_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object address_ = "";
    /**
     * <code>string address = 6;</code>
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        address_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string address = 6;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string address = 6;</code>
     */
    public Builder setAddress(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      address_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string address = 6;</code>
     */
    public Builder clearAddress() {
      
      address_ = getDefaultInstance().getAddress();
      onChanged();
      return this;
    }
    /**
     * <code>string address = 6;</code>
     */
    public Builder setAddressBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      address_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object createtime_ = "";
    /**
     * <code>string createtime = 7;</code>
     */
    public java.lang.String getCreatetime() {
      java.lang.Object ref = createtime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        createtime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string createtime = 7;</code>
     */
    public com.google.protobuf.ByteString
        getCreatetimeBytes() {
      java.lang.Object ref = createtime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        createtime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string createtime = 7;</code>
     */
    public Builder setCreatetime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      createtime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string createtime = 7;</code>
     */
    public Builder clearCreatetime() {
      
      createtime_ = getDefaultInstance().getCreatetime();
      onChanged();
      return this;
    }
    /**
     * <code>string createtime = 7;</code>
     */
    public Builder setCreatetimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      createtime_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object updatetime_ = "";
    /**
     * <code>string updatetime = 8;</code>
     */
    public java.lang.String getUpdatetime() {
      java.lang.Object ref = updatetime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        updatetime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string updatetime = 8;</code>
     */
    public com.google.protobuf.ByteString
        getUpdatetimeBytes() {
      java.lang.Object ref = updatetime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        updatetime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string updatetime = 8;</code>
     */
    public Builder setUpdatetime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      updatetime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string updatetime = 8;</code>
     */
    public Builder clearUpdatetime() {
      
      updatetime_ = getDefaultInstance().getUpdatetime();
      onChanged();
      return this;
    }
    /**
     * <code>string updatetime = 8;</code>
     */
    public Builder setUpdatetimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      updatetime_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:device.deviceFix)
  }

  // @@protoc_insertion_point(class_scope:device.deviceFix)
  private static final com.bruce.grpc.lib.device.deviceFix DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.bruce.grpc.lib.device.deviceFix();
  }

  public static com.bruce.grpc.lib.device.deviceFix getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<deviceFix>
      PARSER = new com.google.protobuf.AbstractParser<deviceFix>() {
    @java.lang.Override
    public deviceFix parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new deviceFix(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<deviceFix> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<deviceFix> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.bruce.grpc.lib.device.deviceFix getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
