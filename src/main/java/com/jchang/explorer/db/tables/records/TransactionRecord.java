package com.jchang.explorer.db.tables.records;

import com.jchang.explorer.db.tables.TransactionTable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;

import java.sql.Timestamp;

@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TransactionRecord extends UpdatableRecordImpl<TransactionRecord> implements Record16<String, String, Long, String, String, Long, Short, Timestamp, Integer, Integer, Short, String, Long, Integer, Integer, Timestamp> {

    private static final long serialVersionUID = -498270376;

    /**
     * Setter for <code>public.transaction.hash</code>.
     */
    public void setHash(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.transaction.hash</code>.
     */
    public String getHash() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.transaction.block_hash</code>.
     */
    public void setBlockHash(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.transaction.block_hash</code>.
     */
    public String getBlockHash() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.transaction.block_number</code>.
     */
    public void setBlockNumber(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.transaction.block_number</code>.
     */
    public Long getBlockNumber() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.transaction.from</code>.
     */
    public void setFrom(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.transaction.from</code>.
     */
    public String getFrom() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.transaction.to</code>.
     */
    public void setTo(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.transaction.to</code>.
     */
    public String getTo() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.transaction.value</code>.
     */
    public void setValue(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.transaction.value</code>.
     */
    public Long getValue() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.transaction.status</code>.
     */
    public void setStatus(Short value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.transaction.status</code>.
     */
    public Short getStatus() {
        return (Short) get(6);
    }

    /**
     * Setter for <code>public.transaction.timestamp</code>.
     */
    public void setTimestamp(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.transaction.timestamp</code>.
     */
    public Timestamp getTimestamp() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>public.transaction.nonce</code>.
     */
    public void setNonce(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.transaction.nonce</code>.
     */
    public Integer getNonce() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.transaction.transaction_index</code>.
     */
    public void setTransactionIndex(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.transaction.transaction_index</code>.
     */
    public Integer getTransactionIndex() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.transaction.type</code>.
     */
    public void setType(Short value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.transaction.type</code>.
     */
    public Short getType() {
        return (Short) get(10);
    }

    /**
     * Setter for <code>public.transaction.data</code>.
     */
    public void setData(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.transaction.data</code>.
     */
    public String getData() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.transaction.gas_price</code>.
     */
    public void setGasPrice(Long value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.transaction.gas_price</code>.
     */
    public Long getGasPrice() {
        return (Long) get(12);
    }

    /**
     * Setter for <code>public.transaction.gas_limit</code>.
     */
    public void setGasLimit(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.transaction.gas_limit</code>.
     */
    public Integer getGasLimit() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>public.transaction.gas_used</code>.
     */
    public void setGasUsed(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.transaction.gas_used</code>.
     */
    public Integer getGasUsed() {
        return (Integer) get(14);
    }

    /**
     * Setter for <code>public.transaction.updatetime</code>.
     */
    public void setUpdatetime(Timestamp value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.transaction.updatetime</code>.
     */
    public Timestamp getUpdatetime() {
        return (Timestamp) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<String, String, Long, String, String, Long, Short, Timestamp, Integer, Integer, Short, String, Long, Integer, Integer, Timestamp> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<String, String, Long, String, String, Long, Short, Timestamp, Integer, Integer, Short, String, Long, Integer, Integer, Timestamp> valuesRow() {
        return (Row16) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TransactionTable.TRANSACTION_TABLE.HASH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TransactionTable.TRANSACTION_TABLE.BLOCK_HASH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return TransactionTable.TRANSACTION_TABLE.BLOCK_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TransactionTable.TRANSACTION_TABLE.FROM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TransactionTable.TRANSACTION_TABLE.TO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return TransactionTable.TRANSACTION_TABLE.VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field7() {
        return TransactionTable.TRANSACTION_TABLE.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return TransactionTable.TRANSACTION_TABLE.TIMESTAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return TransactionTable.TRANSACTION_TABLE.NONCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return TransactionTable.TRANSACTION_TABLE.TRANSACTION_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field11() {
        return TransactionTable.TRANSACTION_TABLE.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return TransactionTable.TRANSACTION_TABLE.DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field13() {
        return TransactionTable.TRANSACTION_TABLE.GAS_PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field14() {
        return TransactionTable.TRANSACTION_TABLE.GAS_LIMIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field15() {
        return TransactionTable.TRANSACTION_TABLE.GAS_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field16() {
        return TransactionTable.TRANSACTION_TABLE.UPDATETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getBlockHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getBlockNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component6() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getNonce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component10() {
        return getTransactionIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component11() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component13() {
        return getGasPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component14() {
        return getGasLimit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component15() {
        return getGasUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component16() {
        return getUpdatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getBlockHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getBlockNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value6() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getNonce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getTransactionIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value11() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value13() {
        return getGasPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value14() {
        return getGasLimit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value15() {
        return getGasUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value16() {
        return getUpdatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value1(String value) {
        setHash(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value2(String value) {
        setBlockHash(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value3(Long value) {
        setBlockNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value4(String value) {
        setFrom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value5(String value) {
        setTo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value6(Long value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value7(Short value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value8(Timestamp value) {
        setTimestamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value9(Integer value) {
        setNonce(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value10(Integer value) {
        setTransactionIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value11(Short value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value12(String value) {
        setData(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value13(Long value) {
        setGasPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value14(Integer value) {
        setGasLimit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value15(Integer value) {
        setGasUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord value16(Timestamp value) {
        setUpdatetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionRecord values(String value1, String value2, Long value3, String value4, String value5, Long value6, Short value7, Timestamp value8, Integer value9, Integer value10, Short value11, String value12, Long value13, Integer value14, Integer value15, Timestamp value16) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TransactionRecord
     */
    public TransactionRecord() {
        super(TransactionTable.TRANSACTION_TABLE);
    }

    /**
     * Create a detached, initialised TransactionRecord
     */
    public TransactionRecord(String hash, String blockHash, Long blockNumber, String from, String to, Long value, Short status, Timestamp timestamp, Integer nonce, Integer transactionIndex, Short type, String data, Long gasPrice, Integer gasLimit, Integer gasUsed, Timestamp updatetime) {
        super(TransactionTable.TRANSACTION_TABLE);

        set(0, hash);
        set(1, blockHash);
        set(2, blockNumber);
        set(3, from);
        set(4, to);
        set(5, value);
        set(6, status);
        set(7, timestamp);
        set(8, nonce);
        set(9, transactionIndex);
        set(10, type);
        set(11, data);
        set(12, gasPrice);
        set(13, gasLimit);
        set(14, gasUsed);
        set(15, updatetime);
    }
}
