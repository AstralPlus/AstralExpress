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
import us.hebi.quickbuf.RepeatedMessage;

public final class ArchiveDataOuterClass {
  /**
   * Protobuf type {@code ArchiveData}
   */
  public static final class ArchiveData extends ProtoMessage<ArchiveData> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>repeated uint32 archive_avatar_id_list = 7;</code>
     */
    private final RepeatedInt archiveAvatarIdList = RepeatedInt.newEmptyInstance();

    /**
     * <code>repeated uint32 archive_equipment_id_list = 10;</code>
     */
    private final RepeatedInt archiveEquipmentIdList = RepeatedInt.newEmptyInstance();

    /**
     * <code>repeated .RelicArchive relic_list = 3;</code>
     */
    private final RepeatedMessage<RelicArchiveOuterClass.RelicArchive> relicList = RepeatedMessage.newEmptyInstance(RelicArchiveOuterClass.RelicArchive.getFactory());

    /**
     * <code>repeated .MonsterArchive archive_monster_id_list = 14;</code>
     */
    private final RepeatedMessage<MonsterArchiveOuterClass.MonsterArchive> archiveMonsterIdList = RepeatedMessage.newEmptyInstance(MonsterArchiveOuterClass.MonsterArchive.getFactory());

    private ArchiveData() {
    }

    /**
     * @return a new empty instance of {@code ArchiveData}
     */
    public static ArchiveData newInstance() {
      return new ArchiveData();
    }

    /**
     * <code>repeated uint32 archive_avatar_id_list = 7;</code>
     * @return whether the archiveAvatarIdList field is set
     */
    public boolean hasArchiveAvatarIdList() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>repeated uint32 archive_avatar_id_list = 7;</code>
     * @return this
     */
    public ArchiveData clearArchiveAvatarIdList() {
      bitField0_ &= ~0x00000001;
      archiveAvatarIdList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 archive_avatar_id_list = 7;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableArchiveAvatarIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getArchiveAvatarIdList() {
      return archiveAvatarIdList;
    }

    /**
     * <code>repeated uint32 archive_avatar_id_list = 7;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableArchiveAvatarIdList() {
      bitField0_ |= 0x00000001;
      return archiveAvatarIdList;
    }

    /**
     * <code>repeated uint32 archive_avatar_id_list = 7;</code>
     * @param value the archiveAvatarIdList to add
     * @return this
     */
    public ArchiveData addArchiveAvatarIdList(final int value) {
      bitField0_ |= 0x00000001;
      archiveAvatarIdList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 archive_avatar_id_list = 7;</code>
     * @param values the archiveAvatarIdList to add
     * @return this
     */
    public ArchiveData addAllArchiveAvatarIdList(final int... values) {
      bitField0_ |= 0x00000001;
      archiveAvatarIdList.addAll(values);
      return this;
    }

    /**
     * <code>repeated uint32 archive_equipment_id_list = 10;</code>
     * @return whether the archiveEquipmentIdList field is set
     */
    public boolean hasArchiveEquipmentIdList() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>repeated uint32 archive_equipment_id_list = 10;</code>
     * @return this
     */
    public ArchiveData clearArchiveEquipmentIdList() {
      bitField0_ &= ~0x00000002;
      archiveEquipmentIdList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 archive_equipment_id_list = 10;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableArchiveEquipmentIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getArchiveEquipmentIdList() {
      return archiveEquipmentIdList;
    }

    /**
     * <code>repeated uint32 archive_equipment_id_list = 10;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableArchiveEquipmentIdList() {
      bitField0_ |= 0x00000002;
      return archiveEquipmentIdList;
    }

    /**
     * <code>repeated uint32 archive_equipment_id_list = 10;</code>
     * @param value the archiveEquipmentIdList to add
     * @return this
     */
    public ArchiveData addArchiveEquipmentIdList(final int value) {
      bitField0_ |= 0x00000002;
      archiveEquipmentIdList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 archive_equipment_id_list = 10;</code>
     * @param values the archiveEquipmentIdList to add
     * @return this
     */
    public ArchiveData addAllArchiveEquipmentIdList(final int... values) {
      bitField0_ |= 0x00000002;
      archiveEquipmentIdList.addAll(values);
      return this;
    }

    /**
     * <code>repeated .RelicArchive relic_list = 3;</code>
     * @return whether the relicList field is set
     */
    public boolean hasRelicList() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>repeated .RelicArchive relic_list = 3;</code>
     * @return this
     */
    public ArchiveData clearRelicList() {
      bitField0_ &= ~0x00000004;
      relicList.clear();
      return this;
    }

    /**
     * <code>repeated .RelicArchive relic_list = 3;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableRelicList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<RelicArchiveOuterClass.RelicArchive> getRelicList() {
      return relicList;
    }

    /**
     * <code>repeated .RelicArchive relic_list = 3;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<RelicArchiveOuterClass.RelicArchive> getMutableRelicList() {
      bitField0_ |= 0x00000004;
      return relicList;
    }

    /**
     * <code>repeated .RelicArchive relic_list = 3;</code>
     * @param value the relicList to add
     * @return this
     */
    public ArchiveData addRelicList(final RelicArchiveOuterClass.RelicArchive value) {
      bitField0_ |= 0x00000004;
      relicList.add(value);
      return this;
    }

    /**
     * <code>repeated .RelicArchive relic_list = 3;</code>
     * @param values the relicList to add
     * @return this
     */
    public ArchiveData addAllRelicList(final RelicArchiveOuterClass.RelicArchive... values) {
      bitField0_ |= 0x00000004;
      relicList.addAll(values);
      return this;
    }

    /**
     * <code>repeated .MonsterArchive archive_monster_id_list = 14;</code>
     * @return whether the archiveMonsterIdList field is set
     */
    public boolean hasArchiveMonsterIdList() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>repeated .MonsterArchive archive_monster_id_list = 14;</code>
     * @return this
     */
    public ArchiveData clearArchiveMonsterIdList() {
      bitField0_ &= ~0x00000008;
      archiveMonsterIdList.clear();
      return this;
    }

    /**
     * <code>repeated .MonsterArchive archive_monster_id_list = 14;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableArchiveMonsterIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<MonsterArchiveOuterClass.MonsterArchive> getArchiveMonsterIdList() {
      return archiveMonsterIdList;
    }

    /**
     * <code>repeated .MonsterArchive archive_monster_id_list = 14;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<MonsterArchiveOuterClass.MonsterArchive> getMutableArchiveMonsterIdList(
        ) {
      bitField0_ |= 0x00000008;
      return archiveMonsterIdList;
    }

    /**
     * <code>repeated .MonsterArchive archive_monster_id_list = 14;</code>
     * @param value the archiveMonsterIdList to add
     * @return this
     */
    public ArchiveData addArchiveMonsterIdList(
        final MonsterArchiveOuterClass.MonsterArchive value) {
      bitField0_ |= 0x00000008;
      archiveMonsterIdList.add(value);
      return this;
    }

    /**
     * <code>repeated .MonsterArchive archive_monster_id_list = 14;</code>
     * @param values the archiveMonsterIdList to add
     * @return this
     */
    public ArchiveData addAllArchiveMonsterIdList(
        final MonsterArchiveOuterClass.MonsterArchive... values) {
      bitField0_ |= 0x00000008;
      archiveMonsterIdList.addAll(values);
      return this;
    }

    @Override
    public ArchiveData copyFrom(final ArchiveData other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        archiveAvatarIdList.copyFrom(other.archiveAvatarIdList);
        archiveEquipmentIdList.copyFrom(other.archiveEquipmentIdList);
        relicList.copyFrom(other.relicList);
        archiveMonsterIdList.copyFrom(other.archiveMonsterIdList);
      }
      return this;
    }

    @Override
    public ArchiveData mergeFrom(final ArchiveData other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasArchiveAvatarIdList()) {
        getMutableArchiveAvatarIdList().addAll(other.archiveAvatarIdList);
      }
      if (other.hasArchiveEquipmentIdList()) {
        getMutableArchiveEquipmentIdList().addAll(other.archiveEquipmentIdList);
      }
      if (other.hasRelicList()) {
        getMutableRelicList().addAll(other.relicList);
      }
      if (other.hasArchiveMonsterIdList()) {
        getMutableArchiveMonsterIdList().addAll(other.archiveMonsterIdList);
      }
      return this;
    }

    @Override
    public ArchiveData clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      archiveAvatarIdList.clear();
      archiveEquipmentIdList.clear();
      relicList.clear();
      archiveMonsterIdList.clear();
      return this;
    }

    @Override
    public ArchiveData clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      archiveAvatarIdList.clear();
      archiveEquipmentIdList.clear();
      relicList.clearQuick();
      archiveMonsterIdList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ArchiveData)) {
        return false;
      }
      ArchiveData other = (ArchiveData) o;
      return bitField0_ == other.bitField0_
        && (!hasArchiveAvatarIdList() || archiveAvatarIdList.equals(other.archiveAvatarIdList))
        && (!hasArchiveEquipmentIdList() || archiveEquipmentIdList.equals(other.archiveEquipmentIdList))
        && (!hasRelicList() || relicList.equals(other.relicList))
        && (!hasArchiveMonsterIdList() || archiveMonsterIdList.equals(other.archiveMonsterIdList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        for (int i = 0; i < archiveAvatarIdList.length(); i++) {
          output.writeRawByte((byte) 56);
          output.writeUInt32NoTag(archiveAvatarIdList.array()[i]);
        }
      }
      if ((bitField0_ & 0x00000002) != 0) {
        for (int i = 0; i < archiveEquipmentIdList.length(); i++) {
          output.writeRawByte((byte) 80);
          output.writeUInt32NoTag(archiveEquipmentIdList.array()[i]);
        }
      }
      if ((bitField0_ & 0x00000004) != 0) {
        for (int i = 0; i < relicList.length(); i++) {
          output.writeRawByte((byte) 26);
          output.writeMessageNoTag(relicList.get(i));
        }
      }
      if ((bitField0_ & 0x00000008) != 0) {
        for (int i = 0; i < archiveMonsterIdList.length(); i++) {
          output.writeRawByte((byte) 114);
          output.writeMessageNoTag(archiveMonsterIdList.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += (1 * archiveAvatarIdList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(archiveAvatarIdList);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += (1 * archiveEquipmentIdList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(archiveEquipmentIdList);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += (1 * relicList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(relicList);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += (1 * archiveMonsterIdList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(archiveMonsterIdList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public ArchiveData mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 58: {
            // archiveAvatarIdList [packed=true]
            input.readPackedUInt32(archiveAvatarIdList, tag);
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 82) {
              break;
            }
          }
          case 82: {
            // archiveEquipmentIdList [packed=true]
            input.readPackedUInt32(archiveEquipmentIdList, tag);
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 26) {
              break;
            }
          }
          case 26: {
            // relicList
            tag = input.readRepeatedMessage(relicList, tag);
            bitField0_ |= 0x00000004;
            if (tag != 114) {
              break;
            }
          }
          case 114: {
            // archiveMonsterIdList
            tag = input.readRepeatedMessage(archiveMonsterIdList, tag);
            bitField0_ |= 0x00000008;
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
          case 56: {
            // archiveAvatarIdList [packed=false]
            tag = input.readRepeatedUInt32(archiveAvatarIdList, tag);
            bitField0_ |= 0x00000001;
            break;
          }
          case 80: {
            // archiveEquipmentIdList [packed=false]
            tag = input.readRepeatedUInt32(archiveEquipmentIdList, tag);
            bitField0_ |= 0x00000002;
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRepeatedUInt32(FieldNames.archiveAvatarIdList, archiveAvatarIdList);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRepeatedUInt32(FieldNames.archiveEquipmentIdList, archiveEquipmentIdList);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRepeatedMessage(FieldNames.relicList, relicList);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRepeatedMessage(FieldNames.archiveMonsterIdList, archiveMonsterIdList);
      }
      output.endObject();
    }

    @Override
    public ArchiveData mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 500094196:
          case 1198392697: {
            if (input.isAtField(FieldNames.archiveAvatarIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(archiveAvatarIdList);
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1521227365:
          case 967463252: {
            if (input.isAtField(FieldNames.archiveEquipmentIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(archiveEquipmentIdList);
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 204814001:
          case 2071893482: {
            if (input.isAtField(FieldNames.relicList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(relicList);
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 912174897:
          case 1817787488: {
            if (input.isAtField(FieldNames.archiveMonsterIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(archiveMonsterIdList);
                bitField0_ |= 0x00000008;
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
    public ArchiveData clone() {
      return new ArchiveData().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static ArchiveData parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new ArchiveData(), data).checkInitialized();
    }

    public static ArchiveData parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ArchiveData(), input).checkInitialized();
    }

    public static ArchiveData parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ArchiveData(), input).checkInitialized();
    }

    /**
     * @return factory for creating ArchiveData messages
     */
    public static MessageFactory<ArchiveData> getFactory() {
      return ArchiveDataFactory.INSTANCE;
    }

    private enum ArchiveDataFactory implements MessageFactory<ArchiveData> {
      INSTANCE;

      @Override
      public ArchiveData create() {
        return ArchiveData.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName archiveAvatarIdList = FieldName.forField("archiveAvatarIdList", "archive_avatar_id_list");

      static final FieldName archiveEquipmentIdList = FieldName.forField("archiveEquipmentIdList", "archive_equipment_id_list");

      static final FieldName relicList = FieldName.forField("relicList", "relic_list");

      static final FieldName archiveMonsterIdList = FieldName.forField("archiveMonsterIdList", "archive_monster_id_list");
    }
  }
}
