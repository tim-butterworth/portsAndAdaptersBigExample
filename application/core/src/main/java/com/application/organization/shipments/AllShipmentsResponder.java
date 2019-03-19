package com.application.organization.shipments;

import java.util.List;

public interface AllShipmentsResponder<T> {
    T success(List<CoreShipment> shipments);
    T failure(ShipmentsRepositoryError shipmentsRepositoryError);
}
