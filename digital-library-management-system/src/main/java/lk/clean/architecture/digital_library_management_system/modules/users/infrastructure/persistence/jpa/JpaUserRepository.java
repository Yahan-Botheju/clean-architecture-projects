package lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.jpa;

import lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {

    //user find by id
    Optional<UserEntity> findById(UUID userId);

    @Query(
            "SELECT COUNT(b) " +
                    "FROM BookEntity b " +
                    "WHERE b.borrowedByUser.userId = :userId " +
                    "AND b.status = 'BORROWED'"
    )
    int countActiveBooksByUserId(@Param("userId") UUID userId);
}
