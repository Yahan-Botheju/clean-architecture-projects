package lk.clean.architecture.cart.system.ex02.modules.catalog.api;

import java.util.UUID;

public interface CatalogStockDeductApi {

    //deduct quantity from stock
    void deductStock(UUID productId, int quantity);
}
