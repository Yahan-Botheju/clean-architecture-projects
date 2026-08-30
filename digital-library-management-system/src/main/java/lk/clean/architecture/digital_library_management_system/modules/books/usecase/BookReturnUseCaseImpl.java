package lk.clean.architecture.digital_library_management_system.modules.books.usecase;

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



    }
}
