package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BorrowStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @Column(name = "book_id")
    private UUID bookId;

    @Column(name = "borrowedByUser_Id", nullable = true)
    private UUID borrowedByUserId;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_status", nullable = false)
    private BookStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "borrow_status", nullable = false)
    private BorrowStatus borrowStatus;

}
