package com.application.organization.shipments.fullShipments;

import com.application.organization.shipments.TrackingId;

import java.util.List;

public interface ShipmentsExtractedFromSomewhere {
    List<CoreShipment> getShipments(List<TrackingId> trackingIdsList);
}
