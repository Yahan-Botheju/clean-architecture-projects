package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;

public class GetCartUseCaseImpl implements GetCartUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;

    public GetCartUseCaseImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
