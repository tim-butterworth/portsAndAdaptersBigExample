package com.application.organization.shipments;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ShipmentsRepositoryTest {

    protected abstract ShipmentsRepository getImplementation();
    protected abstract void saveShipment(CoreShipment coreShipment);

    @Test
    public void canSaveAndRetrieveAShipment() {
        ShipmentsRepository implementation = getImplementation();

        Integer initialValueCount = implementation.findAll().bimap((error) -> 0, List::size).getOrElse(0);

        saveShipment(
                ImmutableCoreShipment.builder()
                        .destination("Summer Home")
                        .build()
        );

        List<CoreShipment> shipments = implementation.findAll()
                .getOrElseThrow((Supplier<RuntimeException>) RuntimeException::new);

        assertThat(shipments).hasSize(initialValueCount + 1);

        assertThat(shipments).contains(ImmutableCoreShipment.builder().destination("Summer Home").build());
    }
}