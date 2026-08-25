package lk.clean.architecture.digital_library_management_system.modules.books.domain.models;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;

import java.util.UUID;

public class Book {
    private final UUID bookId;
    private String isbn;
    private String title;
    private String author;
    private BookStatus status;

    public Book(UUID bookId, String isbn, String title, String author, BookStatus status) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    /* __GETTER__ */

    public UUID getBookId() { return bookId; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public BookStatus getStatus() { return status; }

}
