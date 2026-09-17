package lk.clean.architecture.cart.system.ex02.modules.order.usecase;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.repository.OrderRepository;

public class GetOrderDetailsUseCaseImpl implements  GetOrderDetailsUseCase {

    //inject required dependencies
    private final OrderRepository orderRepository;

    public GetOrderDetailsUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
