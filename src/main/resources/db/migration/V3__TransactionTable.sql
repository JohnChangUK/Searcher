CREATE OR REPLACE FUNCTION update_time_column()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updatetime = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TABLE IF NOT EXISTS transaction (
    hash CHAR(66) NOT NULL PRIMARY KEY,
    block_hash CHAR(66) NOT NULL,
    block_number BIGINT NOT NULL,
    "from" CHAR(42) NOT NULL,
    "to" CHAR(42) NOT NULL ,
    value BIGINT DEFAULT NULL,
    status SMALLINT NOT NULL DEFAULT '1',
    timestamp TIMESTAMP DEFAULT NULL,
    nonce INT NOT NULL DEFAULT '0',
    transaction_index INT NOT NULL DEFAULT '0',
    type SMALLINT DEFAULT '0',
    data text,
    gas_price BIGINT DEFAULT NULL,
    gas_limit INT DEFAULT NULL,
    gas_used INT DEFAULT NULL,
    updatetime TIMESTAMP NOT NULL default current_timestamp);

CREATE TRIGGER update_updatetime BEFORE UPDATE ON transaction FOR EACH ROW EXECUTE PROCEDURE update_time_column();
