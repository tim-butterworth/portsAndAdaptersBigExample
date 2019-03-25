package com.application.organization.shipments;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public interface TrackingId {
    UUID id();
}
