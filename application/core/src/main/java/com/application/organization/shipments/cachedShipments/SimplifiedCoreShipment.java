package com.application.organization.shipments.cachedShipments;

import org.immutables.value.Value;

@Value.Immutable
public interface SimplifiedCoreShipment {
    String destination();
}
