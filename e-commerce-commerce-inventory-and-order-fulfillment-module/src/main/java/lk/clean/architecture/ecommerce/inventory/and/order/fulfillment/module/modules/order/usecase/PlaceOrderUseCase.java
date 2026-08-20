package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;

import java.util.UUID;

public interface PlaceOrderUseCase {

    //place new order
    Order placeOrder( UUID customerId, UUID productId, int requestQuantity);
}
