package com.jchang.explorer.dto;

import com.jchang.explorer.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.web3j.protocol.core.methods.response.EthBlock;

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

    public static BlockDto buildBlock(EthBlock.Block ethBlock) {
        return BlockDto.builder()
                .number(ethBlock.getNumber().longValue())
                .hash(ethBlock.getHash())
                .timestamp(new Date(ethBlock.getTimestamp().longValue() * Constant.TimestampFactor))
                .miner(ethBlock.getMiner())
                .difficulty(ethBlock.getDifficulty().intValue())
                .totalDifficulty(ethBlock.getTotalDifficulty().intValue())
                .size(ethBlock.getSize().intValue())
                .gasUsed(ethBlock.getGasUsed().intValue())
                .gasLimit(ethBlock.getGasLimit().intValue())
                .nonce(ethBlock.getNonceRaw())
                .extraData(ethBlock.getExtraData())
                .uncleHash(ethBlock.getSha3Uncles())
                .parentHash(ethBlock.getParentHash())
                .stateRoot(ethBlock.getStateRoot())
                .receiptsRoot(ethBlock.getReceiptsRoot())
                .transactionsRoot(ethBlock.getTransactionsRoot())
                .build();
    }
}
