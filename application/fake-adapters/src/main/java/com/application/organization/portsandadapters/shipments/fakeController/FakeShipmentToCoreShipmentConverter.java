package com.application.organization.portsandadapters.shipments.fakeController;

import com.application.organization.shipments.CoreShipment;
import com.application.organization.shipments.ImmutableCoreShipment;
import org.springframework.stereotype.Component;

@Component
public class FakeShipmentToCoreShipmentConverter {
    public CoreShipment toCoreShipment(FakeShipment shipment) {
        return ImmutableCoreShipment.builder()
                .destination(shipment.getDestination())
                .build();
    }
}
