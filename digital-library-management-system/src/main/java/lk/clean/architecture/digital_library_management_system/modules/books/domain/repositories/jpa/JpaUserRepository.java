package lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.jpa;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
}
