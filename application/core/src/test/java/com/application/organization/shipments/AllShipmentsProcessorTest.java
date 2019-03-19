package com.application.organization.shipments;

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
        ImmutableCoreShipment coreShipment = ImmutableCoreShipment.builder()
                .destination(destinationWithRandomOffset)
                .build();

        AllShipmentsProcessor<String> stringAllShipmentsProcessor = new AllShipmentsProcessor<>(
                getSuccessRepository(Collections.singletonList(coreShipment))
                , getAllShipmentsResponder()
        );

        assertThat(stringAllShipmentsProcessor.execute()).isEqualTo(
                ImmutableCoreShipment.builder()
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

    private ShipmentsRepository getSuccessRepository(List<CoreShipment> shipments) {
        return new ShipmentsRepository() {
            @Override
            public Either<ShipmentsRepositoryError, List<CoreShipment>> findAll() {
                return Either.right(shipments);
            }

            @Override
            public Either<ShipmentsRepositoryError, String> save(CoreShipment shipment) {
                return null;
            }
        };
    }

    private ShipmentsRepository getErrorRepository() {
        return new ShipmentsRepository() {
            @Override
            public Either<ShipmentsRepositoryError, List<CoreShipment>> findAll() {
                return Either.left(new ShipmentsRepositoryError());
            }

            @Override
            public Either<ShipmentsRepositoryError, String> save(CoreShipment shipment) {
                return null;
            }
        };
    }

    private AllShipmentsResponder<String> getAllShipmentsResponder() {
        return new AllShipmentsResponder<String>() {
            @Override
            public String success(List<CoreShipment> shipments) {
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