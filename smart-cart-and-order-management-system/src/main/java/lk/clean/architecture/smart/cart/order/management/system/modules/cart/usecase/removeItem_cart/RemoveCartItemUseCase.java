package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.removeItem_cart;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records.RemoveCartItemResult;

import java.util.UUID;

public interface RemoveCartItemUseCase {

    //remove item from cart
    RemoveCartItemResult removeCartItem(UUID cartId, UUID cartItemId, UUID productId);
}
