package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.all.AllShipmentsResponder;
import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;
import com.application.organization.shipments.cachedShipments.ShipmentsRepositoryError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class WebAllShipmentResponder implements AllShipmentsResponder<ResponseEntity<?>> {

    private final CoreShipmentToShipmentConverter coreShipmentToShipmentConverter;

    public WebAllShipmentResponder(CoreShipmentToShipmentConverter coreShipmentToShipmentConverter) {
        this.coreShipmentToShipmentConverter = coreShipmentToShipmentConverter;
    }

    @Override
    public ResponseEntity<?> success(List<SimplifiedCoreShipment> shipments) {
        List<Shipment> shipmentList = shipments.stream()
                .map(coreShipmentToShipmentConverter::convert)
                .collect(Collectors.toList());

        return ResponseEntity.ok(shipmentList);
    }

    @Override
    public ResponseEntity<?> failure(ShipmentsRepositoryError shipmentsRepositoryError) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(shipmentsRepositoryError.toString());
    }
}
