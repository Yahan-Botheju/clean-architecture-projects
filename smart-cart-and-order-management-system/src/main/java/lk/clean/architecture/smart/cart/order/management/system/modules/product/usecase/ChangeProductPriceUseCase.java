package lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.ChangeProductPriceCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.ChangeProductPriceResult;

public interface ChangeProductPriceUseCase {

    //change product price
    ChangeProductPriceResult changeProductPrice(ChangeProductPriceCommand changeProductPriceCommand);
}
