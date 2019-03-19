package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.AllShipmentsProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/shipments")
public class ShipmentsController {

    private AllShipmentsProcessor<ResponseEntity<?>> allShipmentsProcessor;

    public ShipmentsController(AllShipmentsProcessor<ResponseEntity<?>> allShipmentsProcessor) {
        this.allShipmentsProcessor = allShipmentsProcessor;
    }

    @GetMapping

    public ResponseEntity<?> allShipments() {
        return allShipmentsProcessor.execute();
    }
}
