package com.jchang.explorer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlockDto {

    private long number;
    private String hash;
    private Date timestamp;
    private String miner;
    private long difficulty;
    private long totalDifficulty;
    private int size;
    private int gasUsed;
    private int gasLimit;
    private String nonce;
    private String extraData;
    private String uncleHash;
    private String parentHash;
    private String stateRoot;
    private String receiptsRoot;
    private String transactionsRoot;
}
