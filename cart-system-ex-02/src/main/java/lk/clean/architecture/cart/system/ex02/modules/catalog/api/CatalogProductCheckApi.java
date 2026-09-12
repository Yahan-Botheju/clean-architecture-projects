package lk.clean.architecture.cart.system.ex02.modules.catalog.api;

import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.CatalogProductCheckResult;

import java.util.UUID;

public interface CatalogProductCheckApi {

    //check product availability
    CatalogProductCheckResult checkProductAvailability(UUID productId, int requestedQuantity);
}
