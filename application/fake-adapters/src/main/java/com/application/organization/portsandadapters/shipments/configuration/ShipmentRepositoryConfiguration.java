package com.application.organization.portsandadapters.shipments.configuration;

import com.application.organization.portsandadapters.shipments.FakeShipmentsRepository;
import com.application.organization.shipments.cachedShipments.ShipmentsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShipmentRepositoryConfiguration {

    @Bean
    public ShipmentsRepository getShipmentRepository() {
        return new FakeShipmentsRepository();
    }
}
