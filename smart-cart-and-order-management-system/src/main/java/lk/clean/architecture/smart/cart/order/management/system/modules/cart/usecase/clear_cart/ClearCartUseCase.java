package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.clear_cart;

import java.util.UUID;

public interface ClearCartUseCase {

    //clear cart
    void clearCart(UUID cartId);
}
