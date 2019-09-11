package com.jchang.explorer.service;

import com.jchang.explorer.dao.BlockDao;
import com.jchang.explorer.dto.BlockDto;
import com.jchang.explorer.pagination.PageIterator;
import com.jchang.explorer.process.DatabaseSynchronizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BlockService {

    private final DatabaseSynchronizer databaseSynchronizer;
    private final BlockDao blockDao;

    public BlockService(DatabaseSynchronizer databaseSynchronizer, BlockDao blockDao) {
        this.databaseSynchronizer = databaseSynchronizer;
        this.blockDao = blockDao;
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

    public Long getLatestBlockNumber() {
        return blockDao.getLatestBlockNumber();
    }
}
