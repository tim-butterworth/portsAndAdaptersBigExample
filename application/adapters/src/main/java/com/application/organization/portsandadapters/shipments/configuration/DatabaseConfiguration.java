package com.application.organization.portsandadapters.shipments.configuration;

import com.application.organization.portsandadapters.shipments.ShipmentsH2Repository;
import com.application.organization.shipments.ShipmentsRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
public class DatabaseConfiguration {

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource(DataSourceConfiguration dataSourceConfiguration) {
        SingleConnectionDataSource singleConnectionDataSource = new SingleConnectionDataSource();
        singleConnectionDataSource.setUrl(dataSourceConfiguration.getUrl());

        return singleConnectionDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "h2")
    public DataSourceConfiguration dataSourceConfiguration() {
        return new DataSourceConfiguration();
    }

    @Bean
    public ShipmentsRepository shipmentsRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new ShipmentsH2Repository(namedParameterJdbcTemplate);
    }

}
