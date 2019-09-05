CREATE OR REPLACE FUNCTION update_time_column()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updatetime = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TABLE IF NOT EXISTS account (
    hash CHAR(42) NOT NULL PRIMARY KEY,
    type SMALLINT NOT NULL DEFAULT '0',
    balance BIGINT NOT NULL DEFAULT '0',
    nonce INT NOT NULL DEFAULT '0',
    addtime TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updatetime TIMESTAMP NOT NULL DEFAULT current_timestamp);

CREATE TRIGGER update_updatetime BEFORE UPDATE ON account FOR EACH ROW EXECUTE PROCEDURE update_time_column();
