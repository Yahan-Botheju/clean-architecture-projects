package lk.clean.architecture.cart.system.ex02.modules.order.domain.repository;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    //order find by id
    Optional<Order> getOrderByOrderId(UUID orderId);

    //save order
    Order save(Order order);
}
