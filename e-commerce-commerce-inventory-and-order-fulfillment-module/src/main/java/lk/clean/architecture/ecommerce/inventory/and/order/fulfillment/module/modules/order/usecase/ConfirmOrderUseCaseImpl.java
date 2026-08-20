package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConfirmOrderUseCaseImpl implements ConfirmOrderUseCase {

    //inject required dependencies
    private final OrderRepository orderRepository;

    public ConfirmOrderUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }

    //confirm order
    @Override
    public Order confirmOrder(UUID orderId) {

        Order checkOrderExistence = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

        LocalDateTime currentTime = LocalDateTime.now();
        checkOrderExistence.confirmCheck(currentTime);

        return orderRepository.save(checkOrderExistence);
    }
}
