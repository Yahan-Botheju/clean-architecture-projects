package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.GetCartCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.GetCartResult;

public interface GetCartUseCase {

    //get cart
    GetCartResult getCart(GetCartCommand getCartCommand);
}
