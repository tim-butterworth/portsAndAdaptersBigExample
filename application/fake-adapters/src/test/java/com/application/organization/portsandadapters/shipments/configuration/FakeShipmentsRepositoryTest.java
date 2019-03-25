package com.application.organization.portsandadapters.shipments.configuration;

import com.application.organization.portsandadapters.shipments.FakeShipmentsRepository;
import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;
import com.application.organization.shipments.cachedShipments.ShipmentsRepository;
import com.application.organization.shipments.ShipmentsRepositoryTest;

public class FakeShipmentsRepositoryTest extends ShipmentsRepositoryTest {

    private FakeShipmentsRepository fakeShipmentsRepository;

    @Override
    protected ShipmentsRepository getImplementation() {
        fakeShipmentsRepository = new FakeShipmentsRepository();

        return fakeShipmentsRepository;
    }

    @Override
    protected void saveShipment(SimplifiedCoreShipment simplifiedCoreShipment) {
        fakeShipmentsRepository.save(simplifiedCoreShipment);
    }
}