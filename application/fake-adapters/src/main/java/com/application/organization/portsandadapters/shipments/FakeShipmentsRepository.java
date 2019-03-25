package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;
import com.application.organization.shipments.cachedShipments.ShipmentsRepository;
import com.application.organization.shipments.cachedShipments.ShipmentsRepositoryError;
import io.vavr.control.Either;

import java.util.LinkedList;
import java.util.List;

public class FakeShipmentsRepository implements ShipmentsRepository {

    private List<SimplifiedCoreShipment> shipments = new LinkedList<>();

    @Override
    public Either<ShipmentsRepositoryError, List<SimplifiedCoreShipment>> findAll() {
        return Either.right(shipments);
    }

    public void save(SimplifiedCoreShipment simplifiedCoreShipment) {
        shipments.add(simplifiedCoreShipment);
    }
}
