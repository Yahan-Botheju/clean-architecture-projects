package lk.clean.architecture.smart.cart.order.management.system.modules.product.api;

import lk.clean.architecture.smart.cart.order.management.system.shared_domain.product_shared_api.ActiveProductCheckApiResult;

import java.util.UUID;

public interface ActiveProductCheckApi {

    //check product availability
    ActiveProductCheckApiResult checkProductActive(UUID productId);
}
