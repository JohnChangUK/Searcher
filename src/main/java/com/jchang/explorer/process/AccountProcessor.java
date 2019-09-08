package com.jchang.explorer.process;

import com.jchang.explorer.constant.Constant;
import com.jchang.explorer.dao.AccountDao;
import com.jchang.explorer.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Slf4j
@Component
@EnableScheduling
public class AccountProcessor implements Processor {

    private final Web3j web3j;
    private final AccountDao accountDao;

    public AccountProcessor(Web3j web3j, AccountDao accountDao) {
        this.web3j = web3j;
        this.accountDao = accountDao;
    }

    @Override
    @Scheduled(fixedRate = 4000)
    public void process() {
    }



}
