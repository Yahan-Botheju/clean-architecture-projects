package lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.jpa;

import lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaCartRepository extends JpaRepository<CartEntity , UUID> {

    Optional<CartEntity> findByUserId(UUID userId);

    void deleteByUserId(UUID userId);
}
