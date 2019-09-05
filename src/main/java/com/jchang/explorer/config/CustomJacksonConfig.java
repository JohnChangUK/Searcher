package com.jchang.explorer.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomJacksonConfig extends ObjectMapper {

    public CustomJacksonConfig() {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }
}
