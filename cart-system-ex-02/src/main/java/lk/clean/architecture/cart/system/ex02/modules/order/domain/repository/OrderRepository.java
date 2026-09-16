package lk.clean.architecture.cart.system.ex02.modules.order.domain.repository;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.Order;

public interface OrderRepository {

    //save order
    Order save(Order order);
}
