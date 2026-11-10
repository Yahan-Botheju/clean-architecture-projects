package lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.jpa;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface JpaCartRepository extends JpaRepository<CartEntity, UUID> {

    @Query("SELECT c FROM CartEntity c WHERE c.customerId = :customerId AND c.cartStatus = 'ACTIVE'")
    Optional<CartEntity> findActiveCartByCustomerId(@Param("customerId") UUID customerId);

    Optional<CartEntity> findCartByCartId(UUID cartId);
}
