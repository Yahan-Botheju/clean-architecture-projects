package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.RemoveFromCartCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.RemoveFromCartResult;

public interface RemoveFromCartUseCase {

    //remove from cart
    RemoveFromCartResult removeFromCart(RemoveFromCartCommand removeFromCartCommand);
}
