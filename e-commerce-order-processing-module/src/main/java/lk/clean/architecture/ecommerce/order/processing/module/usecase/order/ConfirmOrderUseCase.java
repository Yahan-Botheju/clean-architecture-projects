package lk.clean.architecture.ecommerce.order.processing.module.usecase.order;

import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;

import java.util.UUID;

public interface ConfirmOrderUseCase {

    //confirm order
    Order confirmOrder(UUID orderId);
}
