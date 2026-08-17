package lk.clean.architecture.ecommerce.order.processing.module.domain.repositories;

import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    //order find by id
    Optional<Order> findById(UUID orderId);

    //create order
    Order save(Order order);
}
