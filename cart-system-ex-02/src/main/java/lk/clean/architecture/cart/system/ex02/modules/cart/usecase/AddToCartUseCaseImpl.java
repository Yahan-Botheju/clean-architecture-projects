package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartResult;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;

public class AddToCartUseCaseImpl implements AddToCartUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;
    private final CatalogProductCheckApi catalogProductCheckApi;

    public AddToCartUseCaseImpl(
            CartRepository cartRepository,
            CatalogProductCheckApi catalogProductCheckApi
    ) {
        this.cartRepository = cartRepository;
        this.catalogProductCheckApi = catalogProductCheckApi;
    }


    public AddToCartResult execute(AddToCartCommand addToCartCommand) {

        if(addToCartCommand.quantity() <= 0){
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
    }
}
