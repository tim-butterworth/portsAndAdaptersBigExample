package com.application.organization.portsandadapters.shipments.configuration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.stream.Collectors;

@Component
public class DataLoader {

    private final JdbcTemplate jdbcTemplate;

    public DataLoader(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void loadTheData() {
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("sql/setup.sql");

            try (
                    InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
            ) {
                String sql = bufferedReader.lines().collect(Collectors.joining());

                jdbcTemplate.execute(sql);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
