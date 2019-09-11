package com.jchang.explorer.response.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MarketCap {

    @JsonProperty("name")
    private String name;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("price_usd")
    private BigDecimal priceUsd;
    @JsonProperty("24h_volume_usd")
    private BigDecimal marketCapUsd;
    @JsonProperty("24_hour_percentage_change")
    private BigDecimal percentageChange24hour;
    private Date createdAt;
}
