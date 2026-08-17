package lk.clean.architecture.ecommerce.order.processing.module.usecase.order;

import lk.clean.architecture.ecommerce.order.processing.module.domain.enums.OrderStatus;
import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;
import lk.clean.architecture.ecommerce.order.processing.module.domain.repositories.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    //inject required dependencies
    private final OrderRepository orderRepository;

    public CreateOrderUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //create new order
    @Override
    public Order createOrder(UUID customerId, BigDecimal totalAmount, String shippingAddress) {

        //generate random id and current time
        UUID newOrderId = UUID.randomUUID();
        LocalDateTime currentTime = LocalDateTime.now();

        //generate new order object
        Order newOrder = new Order(
            newOrderId, customerId,
                totalAmount,
                OrderStatus.PENDING,
                shippingAddress,
                currentTime,
                currentTime
        );
        //domain logic
        newOrder.createOrder(totalAmount, currentTime);

        return orderRepository.save(newOrder);
    }
}
