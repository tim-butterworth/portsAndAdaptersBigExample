package com.application.organization.shipments.all;

import com.application.organization.shipments.cachedShipments.ShipmentsRepositoryError;
import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;

import java.util.List;

public interface AllShipmentsResponder<T> {
    T success(List<SimplifiedCoreShipment> shipments);
    T failure(ShipmentsRepositoryError shipmentsRepositoryError);
}
