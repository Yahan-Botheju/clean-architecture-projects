package lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.repositories;


import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.models.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    //check product existence by sku
    boolean checkProductBySku(String sku);

    //find product by id
    Optional<Product> getProductById(UUID productId);

    //save product
    Product saveProduct(Product product);
}
