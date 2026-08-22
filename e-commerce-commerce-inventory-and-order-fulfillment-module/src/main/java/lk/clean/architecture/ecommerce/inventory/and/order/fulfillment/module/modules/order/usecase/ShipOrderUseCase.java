package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ShipOrderUseCase {

    //ship order
    public Order shipOrder(UUID orderId);
}
