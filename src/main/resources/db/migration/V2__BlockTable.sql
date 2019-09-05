CREATE OR REPLACE FUNCTION update_time_column()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updatetime = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TABLE IF NOT EXISTS block (
    number BIGINT NOT NULL PRIMARY KEY,
    hash CHAR(66) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    miner CHAR(42) NOT NULL,
    difficulty BIGINT NOT NULL ,
    total_difficulty BIGINT NOT NULL,
    size INT NOT NULL,
    gas_used INT DEFAULT NULL,
    gas_limit INT NOT NULL,
    nonce CHAR(18) NOT NULL,
    extra_data text,
    parent_hash CHAR(66) NOT NULL,
    uncle_hash CHAR(66) NOT NULL,
    state_root CHAR(66) NOT NULL,
    receipts_root CHAR(66) NOT NULL,
    transactions_root CHAR(66) NOT NULL,
    addtime TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updatetime TIMESTAMP NOT NULL DEFAULT current_timestamp);

CREATE TRIGGER update_updatetime BEFORE UPDATE ON block FOR EACH ROW EXECUTE PROCEDURE update_time_column();
