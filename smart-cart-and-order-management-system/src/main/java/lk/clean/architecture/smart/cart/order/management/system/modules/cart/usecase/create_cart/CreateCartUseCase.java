package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.create_cart;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records.CreateCartResult;

import java.util.UUID;

public interface CreateCartUseCase {

    //create new cart
    CreateCartResult createCart(UUID customerId);
}
