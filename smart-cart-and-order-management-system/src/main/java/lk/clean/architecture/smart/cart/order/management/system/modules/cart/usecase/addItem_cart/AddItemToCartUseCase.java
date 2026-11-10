package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.addItem_cart;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records.AddItemToCartResult;

import java.util.UUID;

public interface AddItemToCartUseCase {

    //add item to cart
    AddItemToCartResult addItemToCart(UUID cartId, UUID productId, int requestedQuantity);
}
