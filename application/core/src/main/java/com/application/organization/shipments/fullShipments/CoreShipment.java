package com.application.organization.shipments.fullShipments;

import com.application.organization.shipments.TrackingId;
import org.immutables.value.Value;

@Value.Immutable
public interface CoreShipment {
    TrackingId id();
    String destination();
}
