package com.jchang.explorer.api;

import com.jchang.explorer.dto.BlockDto;
import com.jchang.explorer.dto.BlockTransactionCount;
import com.jchang.explorer.pagination.PageIterator;
import com.jchang.explorer.response.model.Block;
import com.jchang.explorer.response.model.Response;
import com.jchang.explorer.service.BlockService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.jchang.explorer.response.model.Response.Code.SUCCESS;

@CrossOrigin
@RestController
@RequestMapping("/blocks")
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @GetMapping
    public Response<Long> latestBlockNumber() {
        var ethBlockNumber = blockService.getLatestBlockNumber();
        return new Response<>(SUCCESS.getCode(), SUCCESS.getMessage(), ethBlockNumber);
    }

    @GetMapping("/latest")
    public Response<List<BlockDto>> latestBlocks() {
        var latestBlocks = blockService.getLatestBlocks(1, 10);
        return new Response<>(SUCCESS.getCode(), SUCCESS.getMessage(), latestBlocks);
    }

    @GetMapping("/miner/{miner}")
    public Response<PageIterator<BlockDto>> getBlocks(@PathVariable String miner) {
        var latestBlocks = blockService.listBlocks(1, 10, miner);
        List<Block> blocks = blockService.convertBlockDtoToResponse(blockService.getLatestBlocks(1, 10));
        List<Long> blockNumbers = blockService.getBlockNumbers(blocks);
        var blockTransactionCounts = blockService.countTransactionInBlocks(blockNumbers);
        return new Response<>(SUCCESS.getCode(), SUCCESS.getMessage(), latestBlocks);
    }

}
