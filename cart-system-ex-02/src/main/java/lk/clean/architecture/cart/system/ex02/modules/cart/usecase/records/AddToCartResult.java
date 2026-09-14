package lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.CartItem;

import java.util.List;
import java.util.UUID;

public record AddToCartResult(
         UUID cartId,
         UUID userId,
         List<CartItem>cartItems,
         double totalPrice
) {
}
