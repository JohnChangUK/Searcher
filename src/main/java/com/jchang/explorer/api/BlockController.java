package com.jchang.explorer.api;

import com.jchang.explorer.dto.BlockDto;
import com.jchang.explorer.pagination.PageIterator;
import com.jchang.explorer.response.model.Response;
import com.jchang.explorer.service.BlockService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/block")
    public Response<PageIterator<BlockDto>> getBlocks() {
        var latestBlocks = blockService.listBlocks(1, 10, "0x05a56e2d52c817161883f50c441c3228cfe54d9f");
        return new Response<>(SUCCESS.getCode(), SUCCESS.getMessage(), latestBlocks);
    }

}
