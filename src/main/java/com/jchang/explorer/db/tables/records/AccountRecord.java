package com.jchang.explorer.db.tables.records;

import com.jchang.explorer.db.tables.AccountTable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import java.sql.Timestamp;

@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record6<String, Short, Long, Integer, Timestamp, Timestamp> {

    private static final long serialVersionUID = 2130330115;

    /**
     * Setter for <code>public.account.hash</code>.
     */
    public void setHash(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.account.hash</code>.
     */
    public String getHash() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.account.type</code>.
     */
    public void setType(Short value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.account.type</code>.
     */
    public Short getType() {
        return (Short) get(1);
    }

    /**
     * Setter for <code>public.account.balance</code>.
     */
    public void setBalance(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.account.balance</code>.
     */
    public Long getBalance() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.account.nonce</code>.
     */
    public void setNonce(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.account.nonce</code>.
     */
    public Integer getNonce() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.account.addtime</code>.
     */
    public void setAddtime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.account.addtime</code>.
     */
    public Timestamp getAddtime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>public.account.updatetime</code>.
     */
    public void setUpdatetime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.account.updatetime</code>.
     */
    public Timestamp getUpdatetime() {
        return (Timestamp) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, Short, Long, Integer, Timestamp, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, Short, Long, Integer, Timestamp, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return AccountTable.ACCOUNT_TABLE.HASH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field2() {
        return AccountTable.ACCOUNT_TABLE.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return AccountTable.ACCOUNT_TABLE.BALANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return AccountTable.ACCOUNT_TABLE.NONCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return AccountTable.ACCOUNT_TABLE.ADDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return AccountTable.ACCOUNT_TABLE.UPDATETIME;
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
    public Short component2() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getBalance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getNonce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getAddtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
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
    public Short value2() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getBalance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getNonce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getAddtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getUpdatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value1(String value) {
        setHash(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value2(Short value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value3(Long value) {
        setBalance(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value4(Integer value) {
        setNonce(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value5(Timestamp value) {
        setAddtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value6(Timestamp value) {
        setUpdatetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord values(String value1, Short value2, Long value3, Integer value4, Timestamp value5, Timestamp value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountRecord
     */
    public AccountRecord() {
        super(AccountTable.ACCOUNT_TABLE);
    }

    /**
     * Create a detached, initialised AccountRecord
     */
    public AccountRecord(String hash, Short type, Long balance, Integer nonce, Timestamp addtime, Timestamp updatetime) {
        super(AccountTable.ACCOUNT_TABLE);

        set(0, hash);
        set(1, type);
        set(2, balance);
        set(3, nonce);
        set(4, addtime);
        set(5, updatetime);
    }
}
