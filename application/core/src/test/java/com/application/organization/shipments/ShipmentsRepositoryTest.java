package com.application.organization.shipments;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ShipmentsRepositoryTest {

    abstract ShipmentsRepository getImplementation();

    @Test
    public void canSaveAndRetrieveAShipment() {
        ShipmentsRepository implementation = getImplementation();

        implementation.save(
                ImmutableCoreShipment.builder()
                        .destination("Summer Home")
                        .build()
        );

        List<CoreShipment> shipments = implementation.findAll()
                .getOrElseThrow((Supplier<RuntimeException>) RuntimeException::new);

        assertThat(shipments).hasSize(1);

        CoreShipment coreShipment = shipments.get(0);
        assertThat(coreShipment).isEqualTo(ImmutableCoreShipment.builder().destination("Summer Home").build());
    }
}