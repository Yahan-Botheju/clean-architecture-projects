package lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.jpa;

import lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID> {

}
