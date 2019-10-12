package com.jchang.explorer.dto;

import com.jchang.explorer.constant.Constant;
import com.jchang.explorer.response.model.Account;
import com.jchang.explorer.response.model.Block;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.joda.time.LocalDate;
import org.web3j.protocol.core.methods.response.EthBlock;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlockDto {

    private long number;
    private String hash;
    private LocalDateTime timestamp;
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
                .timestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(ethBlock.getTimestamp().longValue() * Constant.TimestampFactor), ZoneId.systemDefault()))
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

    public static BlockDto buildBlockDto(
            Long number, String hash, LocalDateTime localDateTime,
            String miner, Long difficulty, Long totalDifficulty, Integer size,
            Integer gasUsed, Integer gasLimit, String nonce,
            String extraData, String parentHash, String uncleHash, String stateRoot,
            String receiptsRoot, String transactionsRoot) {
        return BlockDto.builder()
                .number(number)
                .hash(hash)
                .timestamp(localDateTime)
                .miner(miner)
                .difficulty(difficulty)
                .totalDifficulty(totalDifficulty)
                .size(size)
                .gasUsed(gasUsed)
                .gasLimit(gasLimit)
                .nonce(nonce)
                .extraData(extraData)
                .parentHash(parentHash)
                .uncleHash(uncleHash)
                .stateRoot(stateRoot)
                .receiptsRoot(receiptsRoot)
                .transactionsRoot(transactionsRoot)
                .build();
    }

    public static List<Block> blocksWithTxCount(
            List<Block> blocks, List<BlockTransactionCount> blockTransactionCounts) {
        Map<Long, Long> blockTxCounts = blockTransactionCounts.stream()
                .collect(Collectors.toMap(BlockTransactionCount::getBlock, BlockTransactionCount::getCount));
        for (var block : blocks) {
            Long count = blockTxCounts.get(block.getHeight());
            block.setTxnCnt(count == null ? 0 : count);
        }
        return blocks;
    }

    Function<BlockDto, Block> toBlockResponse = block ->
            Block.builder()
                    .hash(block.getHash())
                    .height(block.getNumber())
                    .timestamp(Date.from(block.getTimestamp().atZone(ZoneId.systemDefault()).toInstant()))
                    .parentHash(block.getParentHash())
                    .miner(Account.builder().hash(block.getMiner()).build())
                    .gasLimit((long) block.gasLimit)
                    .currentTimestamp(LocalDate.now().toDate())
                    .timeDiff((LocalDate.now().toDate().getTime() - block.getTimestamp().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()) / Constant.TimestampFactor)
                    .build();
}
