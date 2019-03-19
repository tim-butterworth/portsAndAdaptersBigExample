package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.CoreShipment;

public class CoreShipmentToShipmentConverter {
    public Shipment convert(CoreShipment shipment) {
        return new Shipment();
    }
}
