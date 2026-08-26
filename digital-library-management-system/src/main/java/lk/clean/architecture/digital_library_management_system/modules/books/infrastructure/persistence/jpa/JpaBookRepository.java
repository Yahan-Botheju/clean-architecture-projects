package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.jpa;

import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaBookRepository extends JpaRepository<BookEntity, UUID> {

    boolean existsById(UUID bookId);
}
