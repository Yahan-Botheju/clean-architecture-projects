package lk.clean.architecture.digital_library_management_system.modules.books.domain.models;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BorrowStatus;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class Book {
    private final UUID bookId;
    private UUID borrowedByUserId;
    private String isbn;
    private String title;
    private String author;
    private BookStatus status;
    private BorrowStatus  borrowStatus;

    public Book(UUID bookId, UUID borrowedByUserId, String isbn, String title, String author, BookStatus status, BorrowStatus borrowStatus) {
        this.bookId = bookId;
        this.borrowedByUserId = borrowedByUserId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.status = status;
        this.borrowStatus = borrowStatus;
    }

    /* __GETTER__ */

    public UUID getBookId() { return bookId; }
    public UUID getUserId() { return borrowedByUserId; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public BookStatus getStatus() { return status; }
    public BorrowStatus getBorrowStatus() { return borrowStatus; }


    /* __DOMAIN_LOGICS__ */


    //check book status
    public void borrowBook(UUID userId) {
        if(this.status != BookStatus.AVAILABLE) {
            throw new ResourceNotFoundException("Book status is not AVAILABLE");
        }
        this.status = BookStatus.BORROWED;
        this.borrowStatus = BorrowStatus.ACTIVE;
        this.borrowedByUserId = userId;
    }

    //return a book
    public void returnBook() {
        if(this.status != BookStatus.BORROWED){
            throw new IllegalStateException("Book has not BORROWED");
        }
        this.status = BookStatus.AVAILABLE;
        this.borrowStatus = BorrowStatus.RETURNED;
        this.borrowedByUserId = null;
    }
}
