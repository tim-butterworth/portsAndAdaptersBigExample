package com.application.organization.shipments;

import io.vavr.control.Either;

import java.util.List;

public interface ShipmentsRepository {
    Either<ShipmentsRepositoryError, List<CoreShipment>> findAll();
    Either<ShipmentsRepositoryError, String> save(CoreShipment shipment);
}
