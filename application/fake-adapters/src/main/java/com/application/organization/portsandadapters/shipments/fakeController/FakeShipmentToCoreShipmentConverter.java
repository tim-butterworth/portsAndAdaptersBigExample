package com.application.organization.portsandadapters.shipments.fakeController;

import com.application.organization.shipments.cachedShipments.ImmutableSimplifiedCoreShipment;
import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;
import org.springframework.stereotype.Component;

@Component
public class FakeShipmentToCoreShipmentConverter {
    public SimplifiedCoreShipment toCoreShipment(FakeShipment shipment) {
        return ImmutableSimplifiedCoreShipment.builder()
                .destination(shipment.getDestination())
                .build();
    }
}
