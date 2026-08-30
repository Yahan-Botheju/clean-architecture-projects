package lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.models.Book;

import java.util.UUID;

public interface BookRepository {

    //check book existence
    boolean existsById(UUID bookId);

    //get book by id
    Book getBookById(UUID bookId);

    //save borrow book
    Book saveBorrowBook(Book book);

    //check user has same book to borrow
    boolean checkUserBorrowedBooks(UUID userId, UUID bookId);

    //find borrow record and remove
    Book findBorrowedBookRecord(UUID userId, UUID bookId);

    //update returned book
    Book updateBookReturn(Book book);
}
