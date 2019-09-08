package com.jchang.explorer.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class JacksonConfig extends ObjectMapper {

    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    public JacksonConfig() {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        registerModule(new JavaTimeModule());
    }
}
