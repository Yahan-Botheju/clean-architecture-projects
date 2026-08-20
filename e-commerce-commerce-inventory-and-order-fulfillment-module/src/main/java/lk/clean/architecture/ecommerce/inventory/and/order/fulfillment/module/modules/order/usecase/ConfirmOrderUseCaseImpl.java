package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;

public class ConfirmOrderUseCaseImpl implements ConfirmOrderUseCase {

    //inject required dependencies
    private final OrderRepository orderRepository;

    public ConfirmOrderUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }
}
