package com.application.organization.portsandadapters.shipments.configuration;

import com.application.organization.portsandadapters.shipments.FakeShipmentsRepository;
import com.application.organization.shipments.CoreShipment;
import com.application.organization.shipments.ShipmentsRepository;
import com.application.organization.shipments.ShipmentsRepositoryTest;

public class FakeShipmentsRepositoryTest extends ShipmentsRepositoryTest {

    private FakeShipmentsRepository fakeShipmentsRepository;

    @Override
    protected ShipmentsRepository getImplementation() {
        fakeShipmentsRepository = new FakeShipmentsRepository();

        return fakeShipmentsRepository;
    }

    @Override
    protected void saveShipment(CoreShipment coreShipment) {
        fakeShipmentsRepository.save(coreShipment);
    }
}