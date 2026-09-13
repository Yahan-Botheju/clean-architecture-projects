package lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.persistence.jpa;

import lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.persistence.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCartRepository extends JpaRepository<CartEntity , UUID> {
}
