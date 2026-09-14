package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartResult;

public interface AddToCartUseCase {

    //add to cart
    AddToCartResult execute(AddToCartCommand addToCartCommand);
}
