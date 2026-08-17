package lk.clean.architecture.ecommerce.order.processing.module.usecase.order;

import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;

import java.math.BigDecimal;
import java.util.UUID;

public interface CreateOrderUseCase {
    //create new order
    Order createOrder(UUID customerId, BigDecimal totalAmount, String shippingAddress);
}
