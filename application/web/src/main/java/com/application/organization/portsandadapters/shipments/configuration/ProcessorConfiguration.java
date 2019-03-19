package com.application.organization.portsandadapters.shipments.configuration;

import com.application.organization.portsandadapters.shipments.CoreShipmentToShipmentConverter;
import com.application.organization.portsandadapters.shipments.WebAllShipmentResponder;
import com.application.organization.shipments.AllShipmentsProcessor;
import com.application.organization.shipments.AllShipmentsResponder;
import com.application.organization.shipments.ShipmentsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

@Configuration
public class ProcessorConfiguration {

    @Bean
    public AllShipmentsProcessor<ResponseEntity<?>> allShipmentsProcessor(
            ShipmentsRepository shipmentsRepository,
            AllShipmentsResponder<ResponseEntity<?>> allShipmentsResponder
    ) {
        return new AllShipmentsProcessor<>(shipmentsRepository, allShipmentsResponder);
    }

    @Bean
    public AllShipmentsResponder<ResponseEntity<?>> allShipmentsResponder(CoreShipmentToShipmentConverter coreShipmentToShipmentConverter) {
        return new WebAllShipmentResponder(coreShipmentToShipmentConverter);
    }

    @Bean
    public CoreShipmentToShipmentConverter coreShipmentToShipmentConverter() {
        return new CoreShipmentToShipmentConverter();
    }

}
