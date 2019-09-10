package com.jchang.explorer.api;

import com.jchang.explorer.response.model.MarketCap;
import com.jchang.explorer.response.model.Response;
import com.jchang.explorer.service.BlockService;
import com.jchang.explorer.service.MarketCapService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.jchang.explorer.response.model.Response.Code.SUCCESS;

@CrossOrigin
@RestController
@RequestMapping("/marketCap")
public class MarketCapController {

    private final MarketCapService marketCapService;

    public MarketCapController(MarketCapService marketCapService) {
        this.marketCapService = marketCapService;
    }

    @GetMapping(consumes = {MediaType.ALL_VALUE})
    public Response<MarketCap> marketCap(@RequestParam String cryptoCurrency) {
        var cryptoMarketCap = marketCapService.getMarketCap(cryptoCurrency);
        return new Response<>(SUCCESS.getCode(), SUCCESS.getMessage(), cryptoMarketCap);
    }

}
