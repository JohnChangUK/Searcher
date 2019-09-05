package com.jchang.explorer.api;

import com.jchang.explorer.response.model.Response;
import com.jchang.explorer.service.BlockService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

import static com.jchang.explorer.response.model.Response.Code.SUCCESS;

@CrossOrigin
@RestController
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @GetMapping("/blocks")
    public Response<BigInteger> blockCount() {
        var ethBlockNumber = blockService.getEthBlockNumber();
        return new Response<>(SUCCESS.getCode(), SUCCESS.getMessage(), ethBlockNumber.getBlockNumber());
    }

    @GetMapping("/blocks/accounts")
    public Response<List<String>> ethAccountAccountById() {
        var ethBlockNumber = blockService.getEthAccounts();
        return new Response<>(SUCCESS.getCode(), SUCCESS.getMessage(), ethBlockNumber.getAccounts());
    }

}
