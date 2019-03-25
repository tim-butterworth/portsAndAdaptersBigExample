package com.application.organization.shipments;

import com.application.organization.portsandadapters.shipments.configuration.DataLoader;
import com.application.organization.portsandadapters.shipments.configuration.DatabaseConfiguration;
import com.application.organization.shipments.cachedShipments.ShipmentsRepository;
import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        DatabaseConfiguration.class,
        DataLoader.class
})
@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
public class ShipmentsH2RepositoryTest extends ShipmentsRepositoryTest {

    @Autowired
    private ShipmentsRepository shipmentsRepository;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    protected ShipmentsRepository getImplementation() {
        return shipmentsRepository;
    }

    @Override
    protected void saveShipment(SimplifiedCoreShipment simplifiedCoreShipment) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("destination", simplifiedCoreShipment.destination());

        int updateCount = namedParameterJdbcTemplate.update("INSERT INTO SHIPMENTS (destination) values (:destination)", paramMap);
    }
}