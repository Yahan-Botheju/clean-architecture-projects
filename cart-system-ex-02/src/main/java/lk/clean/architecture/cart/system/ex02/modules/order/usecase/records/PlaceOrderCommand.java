package lk.clean.architecture.cart.system.ex02.modules.order.usecase.records;

import java.util.UUID;

public record PlaceOrderCommand(
        UUID userId
) {
}
