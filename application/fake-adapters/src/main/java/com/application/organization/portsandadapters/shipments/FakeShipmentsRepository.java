package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.CoreShipment;
import com.application.organization.shipments.ShipmentsRepository;
import com.application.organization.shipments.ShipmentsRepositoryError;
import io.vavr.control.Either;

import java.util.LinkedList;
import java.util.List;

public class FakeShipmentsRepository implements ShipmentsRepository {

    private List<CoreShipment> shipments = new LinkedList<>();

    @Override
    public Either<ShipmentsRepositoryError, List<CoreShipment>> findAll() {
        return Either.right(shipments);
    }

    public void save(CoreShipment coreShipment) {
        shipments.add(coreShipment);
    }
}
