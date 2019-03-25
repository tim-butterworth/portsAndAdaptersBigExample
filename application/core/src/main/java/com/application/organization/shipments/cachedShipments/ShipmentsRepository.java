package com.application.organization.shipments.cachedShipments;

import io.vavr.control.Either;

import java.util.List;

public interface ShipmentsRepository {
    Either<ShipmentsRepositoryError, List<SimplifiedCoreShipment>> findAll();
}
