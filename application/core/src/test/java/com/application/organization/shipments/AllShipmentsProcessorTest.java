package com.application.organization.shipments;

import com.application.organization.shipments.cachedShipments.ImmutableSimplifiedCoreShipment;
import com.application.organization.shipments.cachedShipments.ShipmentsRepository;
import com.application.organization.shipments.cachedShipments.ShipmentsRepositoryError;
import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;
import com.application.organization.shipments.all.AllShipmentsProcessor;
import com.application.organization.shipments.all.AllShipmentsResponder;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class AllShipmentsProcessorTest {

    @Test
    void givenASuccessfulRepositoryResponse_returnsSuccessResponse() {
        final String destinationWithRandomOffset = "description" + new Random().nextInt();
        ImmutableSimplifiedCoreShipment coreShipment = ImmutableSimplifiedCoreShipment.builder()
                .destination(destinationWithRandomOffset)
                .build();

        AllShipmentsProcessor<String> stringAllShipmentsProcessor = new AllShipmentsProcessor<>(
                getSuccessRepository(Collections.singletonList(coreShipment))
                , getAllShipmentsResponder()
        );

        assertThat(stringAllShipmentsProcessor.execute()).isEqualTo(
                ImmutableSimplifiedCoreShipment.builder()
                        .destination(destinationWithRandomOffset)
                        .build()
                        .toString()
        );
    }

    @Test
    void givenAnErrorRepositoryResponse_returnsErrorResponse() {
        AllShipmentsProcessor<String> allShipmentsProcessor = new AllShipmentsProcessor<>(
                getErrorRepository()
                , getAllShipmentsResponder()
        );

        String result = allShipmentsProcessor.execute();

        assertThat(result).isEqualTo("This was a failure... I know that now");
    }

    private ShipmentsRepository getSuccessRepository(List<SimplifiedCoreShipment> shipments) {
        return new ShipmentsRepository() {
            @Override
            public Either<ShipmentsRepositoryError, List<SimplifiedCoreShipment>> findAll() {
                return Either.right(shipments);
            }
        };
    }

    private ShipmentsRepository getErrorRepository() {
        return new ShipmentsRepository() {
            @Override
            public Either<ShipmentsRepositoryError, List<SimplifiedCoreShipment>> findAll() {
                return Either.left(new ShipmentsRepositoryError());
            }
        };
    }

    private AllShipmentsResponder<String> getAllShipmentsResponder() {
        return new AllShipmentsResponder<String>() {
            @Override
            public String success(List<SimplifiedCoreShipment> shipments) {
                return shipments.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
            }

            @Override
            public String failure(ShipmentsRepositoryError shipmentsRepositoryError) {
                return "This was a failure... I know that now";
            }
        };
    }
}