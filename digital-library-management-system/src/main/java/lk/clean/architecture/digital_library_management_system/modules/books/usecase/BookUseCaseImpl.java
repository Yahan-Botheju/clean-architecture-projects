package lk.clean.architecture.digital_library_management_system.modules.books.usecase;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowResult;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;

public class BookUseCaseImpl implements BookUseCase {

    //inject required dependencies
    private final BookRepository bookRepository;
    private final UserDetailsApi userDetailsApi;

    public BookUseCaseImpl(BookRepository bookRepository, UserDetailsApi userDetailsApi) {
        this.bookRepository = bookRepository;
        this.userDetailsApi = userDetailsApi;
    }

    @Override
    public BookBorrowResult bookBorrow(BookBorrowCommand bookBorrowCommand){


            return null;
    }
}
