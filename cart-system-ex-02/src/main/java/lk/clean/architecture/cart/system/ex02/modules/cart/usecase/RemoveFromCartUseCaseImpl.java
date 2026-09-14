package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;

public class RemoveFromCartUseCaseImpl implements RemoveFromCartUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;
    private final CatalogProductCheckApi catalogProductCheckApi;

    public RemoveFromCartUseCaseImpl(
            CartRepository cartRepository,
            CatalogProductCheckApi catalogProductCheckApi
    ) {
        this.cartRepository = cartRepository;
        this.catalogProductCheckApi = catalogProductCheckApi;
    }
}
