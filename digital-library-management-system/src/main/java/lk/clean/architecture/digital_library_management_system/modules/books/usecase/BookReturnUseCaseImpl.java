package lk.clean.architecture.digital_library_management_system.modules.books.usecase;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.models.Book;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookReturnCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookReturnResult;

public class BookReturnUseCaseImpl implements BookReturnUseCase {

    //inject required dependencies
    private final BookRepository bookRepository;

    public BookReturnUseCaseImpl(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    //check user has same book to borrow
    @Override
    public BookReturnResult returnBook(BookReturnCommand bookReturnCommand) {

        //find active borrow record
        Book activeBook = bookRepository.findBorrowedBookRecord(bookReturnCommand.userId(), bookReturnCommand.bookId());

        /*
        * domain logic =>
        * book borrow status returned
        * book status borrowed -> available
        *
        */
        activeBook.returnBook();

        //update book
        Book returendBook = bookRepository.updateBookReturn(activeBook);

        return new BookReturnResult(
                returendBook.getBookId(),
                returendBook.getTitle(),
                returendBook.getUserId(),
                returendBook.getIsbn(),
                returendBook.getStatus(),
                returendBook.getBorrowStatus()
        );
    }
}