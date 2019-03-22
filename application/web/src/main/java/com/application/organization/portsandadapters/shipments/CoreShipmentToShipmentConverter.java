package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.CoreShipment;

public class CoreShipmentToShipmentConverter {
    public Shipment convert(CoreShipment coreShipment) {
        Shipment shipment = new Shipment();
        shipment.setDestination(coreShipment.destination());
        return shipment;
    }
}
