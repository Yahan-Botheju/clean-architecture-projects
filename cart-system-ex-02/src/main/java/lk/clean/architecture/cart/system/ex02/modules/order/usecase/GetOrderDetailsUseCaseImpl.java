package lk.clean.architecture.cart.system.ex02.modules.order.usecase;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.Order;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.repository.OrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.GetOrderDetailsCommand;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.GetOrderDetailsResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;


public class GetOrderDetailsUseCaseImpl implements  GetOrderDetailsUseCase {

    //inject required dependencies
    private final OrderRepository orderRepository;

    public GetOrderDetailsUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //get user placed order details
    @Override
    public GetOrderDetailsResult getOrderDetails(GetOrderDetailsCommand getOrderDetailsCommand) {
        //get order check existence
         Order  getOrder = orderRepository.getOrderByUserId(getOrderDetailsCommand.userId())
                 .stream()
                 .findFirst()
                 .orElseThrow(() -> new ResourceNotFoundException("Order not found related to user ID"));

        return new GetOrderDetailsResult(
             getOrder.getOrderId(),
             getOrder.getUserId(),
             getOrder.getTotalAmount(),
             getOrder.getOrderStatus(),
             getOrder.getOrderItems(),
             getOrder.getCreatedAt()
        );
    }
}
