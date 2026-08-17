package lk.clean.architecture.ecommerce.order.processing.module.usecase.order;

import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;
import lk.clean.architecture.ecommerce.order.processing.module.domain.repositories.OrderRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConfirmOrderUseCaseImpl implements ConfirmOrderUseCase {

    //inject required dependencies
    private OrderRepository orderRepository;

    public ConfirmOrderUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //confirm order
    @Override
    public Order confirmOrder(UUID orderId) {

        //check order existence
        Order checkOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

        LocalDateTime currentTime = LocalDateTime.now();
        //domain logic
        checkOrder.confirmOrder(currentTime);

        return orderRepository.save(checkOrder);
    }
}
