package lk.clean.architecture.cart.system.ex02.modules.order.usecase;

import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.PlaceOrderCommand;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.PlaceOrderResult;

public interface PlaceOrderUseCase {

    //place an order
    PlaceOrderResult placeOrder(PlaceOrderCommand placeOrderCommand);
}
