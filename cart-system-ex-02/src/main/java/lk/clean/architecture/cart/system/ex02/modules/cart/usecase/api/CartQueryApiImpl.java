package lk.clean.architecture.cart.system.ex02.modules.cart.usecase.api;

import lk.clean.architecture.cart.system.ex02.modules.cart.api.CartQueryApi;
import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;

public class CartQueryApiImpl implements CartQueryApi {

    //inject required dependencies
    private final CartRepository cartRepository;

    public CartQueryApiImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
