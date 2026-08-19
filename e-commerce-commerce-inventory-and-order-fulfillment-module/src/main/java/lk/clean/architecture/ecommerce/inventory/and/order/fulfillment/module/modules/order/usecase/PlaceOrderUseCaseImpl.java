package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;

public class PlaceOrderUseCaseImpl implements PlaceOrderUseCase{

    //inject required dependencies
    private final OrderRepository orderRepository;

    public PlaceOrderUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
