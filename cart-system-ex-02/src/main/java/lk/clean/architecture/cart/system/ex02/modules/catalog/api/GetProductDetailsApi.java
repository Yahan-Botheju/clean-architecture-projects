package lk.clean.architecture.cart.system.ex02.modules.catalog.api;

import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.GetProductDetailsResult;

import java.util.UUID;

public interface GetProductDetailsApi {

    //get product details by id
    public GetProductDetailsResult getProductDetails(UUID productId);
}
