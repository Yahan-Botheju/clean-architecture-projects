package lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.jpa;

import lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
}
