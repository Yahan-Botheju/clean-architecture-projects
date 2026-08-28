package lk.clean.architecture.digital_library_management_system.modules.books.domain.models;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class Book {
    private final UUID bookId;
    private UUID borrowedByUserId;
    private String isbn;
    private String title;
    private String author;
    private BookStatus status;

    public Book(UUID bookId, UUID borrowedByUserId, String isbn, String title, String author, BookStatus status) {
        this.bookId = bookId;
        this.borrowedByUserId = borrowedByUserId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    /* __GETTER__ */

    public UUID getBookId() { return bookId; }
    public UUID getUserId() { return borrowedByUserId; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public BookStatus getStatus() { return status; }


    /* __DOMAIN_LOGICS__ */


    //check book status
    public void checkBookStatus(UUID userId) {
        if(this.status != BookStatus.AVAILABLE) {
            throw new ResourceNotFoundException("Book status is not AVAILABLE");
        }
        this.status = BookStatus.BORROWED;
        this.borrowedByUserId = userId;
    }

}
