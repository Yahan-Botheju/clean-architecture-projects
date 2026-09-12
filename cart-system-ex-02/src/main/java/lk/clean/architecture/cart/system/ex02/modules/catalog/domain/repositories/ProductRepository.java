package lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    //product find by id
    Optional<Product> findById(UUID productId);
}
