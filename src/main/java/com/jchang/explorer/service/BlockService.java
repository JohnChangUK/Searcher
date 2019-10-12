package com.jchang.explorer.service;

import com.jchang.explorer.dao.BlockDao;
import com.jchang.explorer.dao.TransactionDao;
import com.jchang.explorer.dto.BlockDto;
import com.jchang.explorer.dto.BlockTransactionCount;
import com.jchang.explorer.pagination.PageIterator;
import com.jchang.explorer.process.DatabaseSynchronizer;
import com.jchang.explorer.response.model.Account;
import com.jchang.explorer.response.model.Block;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BlockService {

    private final DatabaseSynchronizer databaseSynchronizer;
    private final BlockDao blockDao;
    private final TransactionDao transactionDao;

    public BlockService(DatabaseSynchronizer databaseSynchronizer, BlockDao blockDao,
                        TransactionDao transactionDao) {
        this.databaseSynchronizer = databaseSynchronizer;
        this.blockDao = blockDao;
        this.transactionDao = transactionDao;
    }

    public List<BlockDto> getLatestBlocks(int page, int pageSize) {
        Long lastNumber = getLatestBlockNumber();
        List<BlockDto> blocks = new ArrayList<>();
        if (lastNumber != null) {
            long endNumber = lastNumber - (page - 1) * pageSize;
            long startNumber = lastNumber - page * 10;
            if (startNumber < 0) {
                startNumber = 0;
            }
            if (endNumber < startNumber) {
                endNumber = startNumber;
            }

            List<BlockDto> blockDtos = blockDao.sortBlocksByLatest(startNumber, endNumber);
            if (blockDtos != null) {
                blocks.addAll(blockDtos);
            }
        }

        return blocks;
    }

    public PageIterator<BlockDto> listBlocks(int page, int pageSize, String miner) {
        long blockCount = blockDao.getBlockCount();
        PageIterator<BlockDto> pageIterator = PageIterator.create(page, pageSize, blockCount);
        if (blockCount > 0) {
            List<BlockDto> minerBlocks = blockDao.getMinerBlocks(
                    pageIterator.getOffSet(), pageIterator.getPageSize(), miner);
            if (minerBlocks != null) {
                pageIterator.getResult().addAll(minerBlocks);
            }
        }
        return pageIterator;
    }

    public List<Block> convertBlockDtoToResponse(List<BlockDto> blockDtos) {
        return blockDtos.stream()
                .map(dto -> Block.builder()
                        .hash(dto.getHash())
                        .height(dto.getNumber())
                        .timestamp(dto.getTimestamp())
                        .parentHash(dto.getParentHash())
                        .miner(Account.builder().hash(dto.getMiner()).build())
                        .currentTimestamp(LocalDateTime.now())
                        .timeDiff(Duration.between(LocalDateTime.now(), dto.getTimestamp()).toHours())
                        .build())
                .collect(Collectors.toList());
    }

    public Long getLatestBlockNumber() {
        return blockDao.getLatestBlockNumber();
    }

    public List<Long> getBlockNumbers(List<Block> blocks) {
        return blocks.stream()
                .map(Block::getHeight)
                .collect(Collectors.toList());
    }

    public List<BlockTransactionCount> countTransactionInBlocks(List<Long> blockNumbers) {
        return blockNumbers.isEmpty() ? new ArrayList<>() : transactionDao.countTxInBlocks(blockNumbers);
    }
}
