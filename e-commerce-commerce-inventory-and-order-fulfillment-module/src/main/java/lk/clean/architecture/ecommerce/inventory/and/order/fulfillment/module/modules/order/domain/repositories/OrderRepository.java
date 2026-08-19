package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Optional<Order> findById(UUID productId);
}
