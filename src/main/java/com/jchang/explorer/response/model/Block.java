package com.jchang.explorer.response.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Block extends Response<Block> {

    private String hash;
    private Long height;
    private Date timestamp;
    private String parentHash;
    private Account miner;
    private Long txnCnt = 0L;
    private Long gasLimit;
    private String avgGasPrice; //sum(tx.gasPrice)/count(tx)
    private String gasReward; //sum(tx.gasUsed * tx.gasPrice)
    private Date currentTimestamp;
    private Long timeDiff;
    private Long maxHeight;

    @Override
    public void setResult(Block result) {
        super.setResult(result);
    }
}
