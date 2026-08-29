package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.jpa;

import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface JpaBookRepository extends JpaRepository<BookEntity, UUID> {

    boolean existsById(UUID bookId);

    //create custom query to check same books are already in user entity
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END " +
            "FROM BookEntity b " +
            "WHERE b.borrowedByUserId = :userId " +
            "AND LOWER(b.title) = LOWER(:title) " +
            "AND b.status = 'BORROWED'")
    boolean checkUserBorrowedBooks(
            @Param("userId") UUID userId,
            @Param("title") String title
    );
}
