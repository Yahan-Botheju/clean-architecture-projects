package lk.clean.architecture.cart.system.ex02.modules.cart.api;

import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.CartDetailsResult;

import java.util.UUID;

public interface CartQueryApi {

    CartDetailsResult getCartByUserId(UUID userId);
}
