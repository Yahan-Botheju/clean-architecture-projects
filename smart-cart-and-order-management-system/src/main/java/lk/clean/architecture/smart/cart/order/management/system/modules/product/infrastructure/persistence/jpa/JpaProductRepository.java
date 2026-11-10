package lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.jpa;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaProductRepository extends JpaRepository<ProductEntity, UUID> {

    //check product existence by sku
    boolean findBySku(String sku);

    //find product by id
    Optional<ProductEntity> findById(UUID productId);
}
