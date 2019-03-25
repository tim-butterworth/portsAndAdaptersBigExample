package com.application.organization.shipments;

import com.application.organization.shipments.cachedShipments.ImmutableSimplifiedCoreShipment;
import com.application.organization.shipments.cachedShipments.ShipmentsRepository;
import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ShipmentsRepositoryTest {

    protected abstract ShipmentsRepository getImplementation();
    protected abstract void saveShipment(SimplifiedCoreShipment simplifiedCoreShipment);

    @Test
    public void canSaveAndRetrieveAShipment() {
        ShipmentsRepository implementation = getImplementation();

        Integer initialValueCount = implementation.findAll().bimap((error) -> 0, List::size).getOrElse(0);

        saveShipment(
                ImmutableSimplifiedCoreShipment.builder()
                        .destination("Summer Home")
                        .build()
        );

        List<SimplifiedCoreShipment> shipments = implementation.findAll()
                .getOrElseThrow((Supplier<RuntimeException>) RuntimeException::new);

        assertThat(shipments).hasSize(initialValueCount + 1);

        assertThat(shipments).contains(ImmutableSimplifiedCoreShipment.builder().destination("Summer Home").build());
    }
}