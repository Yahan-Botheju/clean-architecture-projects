package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.changeItemQuantity_cart;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records.ChangeCartItemQuantityResult;

import java.util.UUID;

public interface ChangeCartItemQuantityUseCase {

    //change cart item quantity
    ChangeCartItemQuantityResult changeCartItemQuantity(UUID cartId, UUID cartItemId, int newQuantity);
}
