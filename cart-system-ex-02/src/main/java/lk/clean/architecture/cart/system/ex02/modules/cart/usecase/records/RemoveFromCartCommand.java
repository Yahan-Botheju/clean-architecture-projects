package lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records;

import java.util.UUID;

public record RemoveFromCartCommand(
        UUID userId,
        UUID productId
) {
}
