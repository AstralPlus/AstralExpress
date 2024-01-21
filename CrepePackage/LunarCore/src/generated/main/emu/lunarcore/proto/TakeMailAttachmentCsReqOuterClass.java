// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import java.io.IOException;
import us.hebi.quickbuf.FieldName;
import us.hebi.quickbuf.InvalidProtocolBufferException;
import us.hebi.quickbuf.JsonSink;
import us.hebi.quickbuf.JsonSource;
import us.hebi.quickbuf.MessageFactory;
import us.hebi.quickbuf.ProtoMessage;
import us.hebi.quickbuf.ProtoSink;
import us.hebi.quickbuf.ProtoSource;
import us.hebi.quickbuf.RepeatedInt;

public final class TakeMailAttachmentCsReqOuterClass {
  /**
   * Protobuf type {@code TakeMailAttachmentCsReq}
   */
  public static final class TakeMailAttachmentCsReq extends ProtoMessage<TakeMailAttachmentCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>repeated uint32 mail_id_list = 12;</code>
     */
    private final RepeatedInt mailIdList = RepeatedInt.newEmptyInstance();

    private TakeMailAttachmentCsReq() {
    }

    /**
     * @return a new empty instance of {@code TakeMailAttachmentCsReq}
     */
    public static TakeMailAttachmentCsReq newInstance() {
      return new TakeMailAttachmentCsReq();
    }

    /**
     * <code>repeated uint32 mail_id_list = 12;</code>
     * @return whether the mailIdList field is set
     */
    public boolean hasMailIdList() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>repeated uint32 mail_id_list = 12;</code>
     * @return this
     */
    public TakeMailAttachmentCsReq clearMailIdList() {
      bitField0_ &= ~0x00000001;
      mailIdList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 mail_id_list = 12;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableMailIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getMailIdList() {
      return mailIdList;
    }

    /**
     * <code>repeated uint32 mail_id_list = 12;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableMailIdList() {
      bitField0_ |= 0x00000001;
      return mailIdList;
    }

    /**
     * <code>repeated uint32 mail_id_list = 12;</code>
     * @param value the mailIdList to add
     * @return this
     */
    public TakeMailAttachmentCsReq addMailIdList(final int value) {
      bitField0_ |= 0x00000001;
      mailIdList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 mail_id_list = 12;</code>
     * @param values the mailIdList to add
     * @return this
     */
    public TakeMailAttachmentCsReq addAllMailIdList(final int... values) {
      bitField0_ |= 0x00000001;
      mailIdList.addAll(values);
      return this;
    }

    @Override
    public TakeMailAttachmentCsReq copyFrom(final TakeMailAttachmentCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        mailIdList.copyFrom(other.mailIdList);
      }
      return this;
    }

    @Override
    public TakeMailAttachmentCsReq mergeFrom(final TakeMailAttachmentCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasMailIdList()) {
        getMutableMailIdList().addAll(other.mailIdList);
      }
      return this;
    }

    @Override
    public TakeMailAttachmentCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      mailIdList.clear();
      return this;
    }

    @Override
    public TakeMailAttachmentCsReq clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      mailIdList.clear();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof TakeMailAttachmentCsReq)) {
        return false;
      }
      TakeMailAttachmentCsReq other = (TakeMailAttachmentCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasMailIdList() || mailIdList.equals(other.mailIdList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        for (int i = 0; i < mailIdList.length(); i++) {
          output.writeRawByte((byte) 96);
          output.writeUInt32NoTag(mailIdList.array()[i]);
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += (1 * mailIdList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(mailIdList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public TakeMailAttachmentCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 98: {
            // mailIdList [packed=true]
            input.readPackedUInt32(mailIdList, tag);
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 0) {
              break;
            }
          }
          case 0: {
            return this;
          }
          default: {
            if (!input.skipField(tag)) {
              return this;
            }
            tag = input.readTag();
            break;
          }
          case 96: {
            // mailIdList [packed=false]
            tag = input.readRepeatedUInt32(mailIdList, tag);
            bitField0_ |= 0x00000001;
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRepeatedUInt32(FieldNames.mailIdList, mailIdList);
      }
      output.endObject();
    }

    @Override
    public TakeMailAttachmentCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1612269328:
          case 1599691450: {
            if (input.isAtField(FieldNames.mailIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(mailIdList);
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          default: {
            input.skipUnknownField();
            break;
          }
        }
      }
      input.endObject();
      return this;
    }

    @Override
    public TakeMailAttachmentCsReq clone() {
      return new TakeMailAttachmentCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static TakeMailAttachmentCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new TakeMailAttachmentCsReq(), data).checkInitialized();
    }

    public static TakeMailAttachmentCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new TakeMailAttachmentCsReq(), input).checkInitialized();
    }

    public static TakeMailAttachmentCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new TakeMailAttachmentCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating TakeMailAttachmentCsReq messages
     */
    public static MessageFactory<TakeMailAttachmentCsReq> getFactory() {
      return TakeMailAttachmentCsReqFactory.INSTANCE;
    }

    private enum TakeMailAttachmentCsReqFactory implements MessageFactory<TakeMailAttachmentCsReq> {
      INSTANCE;

      @Override
      public TakeMailAttachmentCsReq create() {
        return TakeMailAttachmentCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName mailIdList = FieldName.forField("mailIdList", "mail_id_list");
    }
  }
}
