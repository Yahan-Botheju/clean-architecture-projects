package lk.clean.architecture.cart.system.ex02.modules.order.usecase;

import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.GetOrderDetailsCommand;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.GetOrderDetailsResult;

public interface GetOrderDetailsUseCase {

    //get details of placed order
    GetOrderDetailsResult getOrderDetails(GetOrderDetailsCommand getOrderDetailsCommand);
}
