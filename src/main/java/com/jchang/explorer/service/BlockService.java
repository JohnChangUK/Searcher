package com.jchang.explorer.service;

import com.jchang.explorer.dao.BlockDao;
import com.jchang.explorer.process.BlockProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlockService {

    private final BlockProcessor blockProcessor;
    private final BlockDao blockDao;

    public BlockService(BlockProcessor blockProcessor, BlockDao blockDao) {
        this.blockProcessor = blockProcessor;
        this.blockDao = blockDao;
    }

    public Long getLatestBlockNumber() {
        return blockDao.getLatestBlockNumber();
    }
}
