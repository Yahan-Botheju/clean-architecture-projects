package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.UpdateCartItemCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.UpdateCartItemResult;

public interface UpdateCartItemUseCase {

    //update cart item
    UpdateCartItemResult execute(UpdateCartItemCommand updateCartItemCommand);
}
