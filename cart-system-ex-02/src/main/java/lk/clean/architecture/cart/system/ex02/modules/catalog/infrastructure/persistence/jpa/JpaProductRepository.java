package lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.jpa;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaProductRepository extends JpaRepository<ProductEntity, UUID> {

    //product find by id
    Optional<ProductEntity>  findByProductId(UUID productId);

    //check product existence
    boolean existsByProductId(UUID productId);
}
