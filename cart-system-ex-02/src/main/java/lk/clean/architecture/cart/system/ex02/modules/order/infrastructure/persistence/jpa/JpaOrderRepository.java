package lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.jpa;

import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID> {

    Optional<OrderEntity> findByOrderId(UUID orderId);
}
