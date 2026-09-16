package lk.clean.architecture.cart.system.ex02.modules.order.domain.repository;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    //order find by id
    Optional<Order> getOrderByOrderId(UUID orderId);

    //get order list related to user id
    List<Order> getOrderByUserId(UUID userId);

    //save order
    Order save(Order order);
}
