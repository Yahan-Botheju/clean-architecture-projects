package lk.clean.architecture.cart.system.ex02.modules.cart.api;

import lk.clean.architecture.cart.system.ex02.modules.shared_domain.cart.api_records.CartDetailsResult;

import java.util.UUID;

public interface CartQueryApi {

    //get cart details
    CartDetailsResult getCartByUserId(UUID userId);

    //clear cart
    void clearCartByUserId(UUID userId);
}
