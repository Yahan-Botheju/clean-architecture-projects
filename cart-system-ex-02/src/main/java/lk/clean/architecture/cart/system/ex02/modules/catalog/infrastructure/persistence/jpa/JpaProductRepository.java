package lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.jpa;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaProductRepository extends JpaRepository<Product, UUID> {
}
