package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;

public class CoreShipmentToShipmentConverter {
    public Shipment convert(SimplifiedCoreShipment simplifiedCoreShipment) {
        Shipment shipment = new Shipment();
        shipment.setDestination(simplifiedCoreShipment.destination());
        return shipment;
    }
}
