package com.application.organization.shipments;

import com.application.organization.portsandadapters.shipments.configuration.DataLoader;
import com.application.organization.portsandadapters.shipments.configuration.DatabaseConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        DatabaseConfiguration.class,
        DataLoader.class
})
class ShipmentsH2RepositoryTest extends ShipmentsRepositoryTest {

    @Autowired
    private ShipmentsRepository shipmentsRepository;

    @Override
    ShipmentsRepository getImplementation() {
        return shipmentsRepository;
    }
}