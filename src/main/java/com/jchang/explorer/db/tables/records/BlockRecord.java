package com.jchang.explorer.db.tables.records;

import com.jchang.explorer.db.tables.BlockTable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.UpdatableRecordImpl;

import java.sql.Timestamp;

@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class BlockRecord extends UpdatableRecordImpl<BlockRecord> implements Record18<Long, String, Timestamp, String, Long, Long, Integer, Integer, Integer, String, String, String, String, String, String, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = 633424188;

    /**
     * Setter for <code>public.block.number</code>.
     */
    public void setNumber(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.block.number</code>.
     */
    public Long getNumber() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.block.hash</code>.
     */
    public void setHash(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.block.hash</code>.
     */
    public String getHash() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.block.timestamp</code>.
     */
    public void setTimestamp(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.block.timestamp</code>.
     */
    public Timestamp getTimestamp() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>public.block.miner</code>.
     */
    public void setMiner(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.block.miner</code>.
     */
    public String getMiner() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.block.difficulty</code>.
     */
    public void setDifficulty(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.block.difficulty</code>.
     */
    public Long getDifficulty() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.block.total_difficulty</code>.
     */
    public void setTotalDifficulty(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.block.total_difficulty</code>.
     */
    public Long getTotalDifficulty() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.block.size</code>.
     */
    public void setSize(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.block.size</code>.
     */
    public Integer getSize() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.block.gas_used</code>.
     */
    public void setGasUsed(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.block.gas_used</code>.
     */
    public Integer getGasUsed() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.block.gas_limit</code>.
     */
    public void setGasLimit(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.block.gas_limit</code>.
     */
    public Integer getGasLimit() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.block.nonce</code>.
     */
    public void setNonce(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.block.nonce</code>.
     */
    public String getNonce() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.block.extra_data</code>.
     */
    public void setExtraData(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.block.extra_data</code>.
     */
    public String getExtraData() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.block.parent_hash</code>.
     */
    public void setParentHash(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.block.parent_hash</code>.
     */
    public String getParentHash() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.block.uncle_hash</code>.
     */
    public void setUncleHash(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.block.uncle_hash</code>.
     */
    public String getUncleHash() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.block.state_root</code>.
     */
    public void setStateRoot(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.block.state_root</code>.
     */
    public String getStateRoot() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.block.receipts_root</code>.
     */
    public void setReceiptsRoot(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.block.receipts_root</code>.
     */
    public String getReceiptsRoot() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.block.transactions_root</code>.
     */
    public void setTransactionsRoot(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.block.transactions_root</code>.
     */
    public String getTransactionsRoot() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.block.addtime</code>.
     */
    public void setAddtime(Timestamp value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.block.addtime</code>.
     */
    public Timestamp getAddtime() {
        return (Timestamp) get(16);
    }

    /**
     * Setter for <code>public.block.updatetime</code>.
     */
    public void setUpdatetime(Timestamp value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.block.updatetime</code>.
     */
    public Timestamp getUpdatetime() {
        return (Timestamp) get(17);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record18 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Long, String, Timestamp, String, Long, Long, Integer, Integer, Integer, String, String, String, String, String, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Long, String, Timestamp, String, Long, Long, Integer, Integer, Integer, String, String, String, String, String, String, String, Timestamp, Timestamp> valuesRow() {
        return (Row18) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return BlockTable.BLOCK_TABLE.NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return BlockTable.BLOCK_TABLE.HASH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return BlockTable.BLOCK_TABLE.TIMESTAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return BlockTable.BLOCK_TABLE.MINER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return BlockTable.BLOCK_TABLE.DIFFICULTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return BlockTable.BLOCK_TABLE.TOTAL_DIFFICULTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return BlockTable.BLOCK_TABLE.SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return BlockTable.BLOCK_TABLE.GAS_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return BlockTable.BLOCK_TABLE.GAS_LIMIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return BlockTable.BLOCK_TABLE.NONCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return BlockTable.BLOCK_TABLE.EXTRA_DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return BlockTable.BLOCK_TABLE.PARENT_HASH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return BlockTable.BLOCK_TABLE.UNCLE_HASH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return BlockTable.BLOCK_TABLE.STATE_ROOT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return BlockTable.BLOCK_TABLE.RECEIPTS_ROOT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return BlockTable.BLOCK_TABLE.TRANSACTIONS_ROOT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field17() {
        return BlockTable.BLOCK_TABLE.ADDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field18() {
        return BlockTable.BLOCK_TABLE.UPDATETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getMiner();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getDifficulty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component6() {
        return getTotalDifficulty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getGasUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getGasLimit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getNonce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getExtraData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getParentHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getUncleHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getStateRoot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getReceiptsRoot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component16() {
        return getTransactionsRoot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component17() {
        return getAddtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component18() {
        return getUpdatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getMiner();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getDifficulty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value6() {
        return getTotalDifficulty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getGasUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getGasLimit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getNonce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getExtraData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getParentHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getUncleHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getStateRoot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getReceiptsRoot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getTransactionsRoot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value17() {
        return getAddtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value18() {
        return getUpdatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value1(Long value) {
        setNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value2(String value) {
        setHash(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value3(Timestamp value) {
        setTimestamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value4(String value) {
        setMiner(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value5(Long value) {
        setDifficulty(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value6(Long value) {
        setTotalDifficulty(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value7(Integer value) {
        setSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value8(Integer value) {
        setGasUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value9(Integer value) {
        setGasLimit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value10(String value) {
        setNonce(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value11(String value) {
        setExtraData(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value12(String value) {
        setParentHash(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value13(String value) {
        setUncleHash(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value14(String value) {
        setStateRoot(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value15(String value) {
        setReceiptsRoot(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value16(String value) {
        setTransactionsRoot(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value17(Timestamp value) {
        setAddtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord value18(Timestamp value) {
        setUpdatetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockRecord values(Long value1, String value2, Timestamp value3, String value4, Long value5, Long value6, Integer value7, Integer value8, Integer value9, String value10, String value11, String value12, String value13, String value14, String value15, String value16, Timestamp value17, Timestamp value18) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BlockRecord
     */
    public BlockRecord() {
        super(BlockTable.BLOCK_TABLE);
    }

    /**
     * Create a detached, initialised BlockRecord
     */
    public BlockRecord(Long number, String hash, Timestamp timestamp, String miner, Long difficulty, Long totalDifficulty, Integer size, Integer gasUsed, Integer gasLimit, String nonce, String extraData, String parentHash, String uncleHash, String stateRoot, String receiptsRoot, String transactionsRoot, Timestamp addtime, Timestamp updatetime) {
        super(BlockTable.BLOCK_TABLE);

        set(0, number);
        set(1, hash);
        set(2, timestamp);
        set(3, miner);
        set(4, difficulty);
        set(5, totalDifficulty);
        set(6, size);
        set(7, gasUsed);
        set(8, gasLimit);
        set(9, nonce);
        set(10, extraData);
        set(11, parentHash);
        set(12, uncleHash);
        set(13, stateRoot);
        set(14, receiptsRoot);
        set(15, transactionsRoot);
        set(16, addtime);
        set(17, updatetime);
    }
}
