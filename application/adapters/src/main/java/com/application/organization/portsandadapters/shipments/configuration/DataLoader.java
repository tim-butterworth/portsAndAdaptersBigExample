package com.application.organization.portsandadapters.shipments.configuration;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class DataLoader implements ResourceLoaderAware {

    private final JdbcTemplate jdbcTemplate;
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public DataLoader(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void loadTheData() {
        try {
            Resource resource = resourceLoader.getResource("classpath:sql/setup.sql");
            File file = resource.getFile();

            try (
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
            ) {
                String sql = bufferedReader.lines().collect(Collectors.joining());

                jdbcTemplate.execute(sql);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
