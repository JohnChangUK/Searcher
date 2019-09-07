package com.jchang.explorer.process;

import com.jchang.explorer.dao.BlockDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;

@Slf4j
@Component
@EnableScheduling
public class BlockProcessor implements Processor {

    private final Web3j web3j;
    private final BlockDao blockDao;

    public BlockProcessor(Web3j web3j, BlockDao blockDao) {
        this.web3j = web3j;
        this.blockDao = blockDao;
    }

    @Override
    @Scheduled(fixedRate = 4000)
    public void process() {
    }
}
