package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.persistence.jpa;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID> {

    //find product by product id
    Optional<OrderEntity> findByProductId(UUID productId);
}
