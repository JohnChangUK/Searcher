package com.jchang.explorer.config;

import com.jchang.explorer.exception.ExceptionTranslator;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.jooq.sql-dialect}")
    private String dialect;
    private final DataSource dataSource;

    public DatabaseConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DefaultDSLContext sql() {
        return new DefaultDSLContext(configuration());
    }

    @Bean
    public DefaultConfiguration configuration() {
        var config = new DefaultConfiguration();
        config.set(new TransactionAwareDataSourceProxy(dataSource));
        config.set(new DefaultExecuteListenerProvider(new ExceptionTranslator()));
        config.set(SQLDialect.valueOf(dialect));
        config.settings().withRenderSchema(false);

        return config;
    }
}
