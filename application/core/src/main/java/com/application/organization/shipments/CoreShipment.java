package com.application.organization.shipments;

import org.immutables.value.Value;

@Value.Immutable
public interface CoreShipment {
    String destination();
}
