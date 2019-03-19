package com.application.organization.shipments;

import io.vavr.control.Either;

public class AllShipmentsProcessor<T> {

    private final ShipmentsRepository shipmentsRepository;
    private final AllShipmentsResponder<T> responder;

    public AllShipmentsProcessor(
            ShipmentsRepository shipmentsRepository,
            AllShipmentsResponder<T> responder
    ) {
        this.shipmentsRepository = shipmentsRepository;
        this.responder = responder;
    }

    public T execute() {
        Either<T, T> responseMapped = shipmentsRepository.findAll()
                .bimap(responder::failure, responder::success);

        if (responseMapped.isLeft()) return responseMapped.getLeft();
        else return responseMapped.get();
    }
}
