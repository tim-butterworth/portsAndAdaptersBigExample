package com.application.organization.portsandadapters.shipments.fakeController;

import com.application.organization.portsandadapters.shipments.FakeShipmentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeShipmentsController {

    private final FakeShipmentsRepository shipmentsRepository;
    private final FakeShipmentToCoreShipmentConverter converter;

    public FakeShipmentsController(
            FakeShipmentsRepository shipmentsRepository,
            FakeShipmentToCoreShipmentConverter converter
    ) {
        this.shipmentsRepository = shipmentsRepository;
        this.converter = converter;
    }

    @PostMapping("/shipments")
    public ResponseEntity<String> addShipment(@RequestBody FakeShipment shipment) {
        shipmentsRepository.save(converter.toCoreShipment(shipment));

        return ResponseEntity.status(HttpStatus.OK).body("Saved the shipment!");
    }
}
