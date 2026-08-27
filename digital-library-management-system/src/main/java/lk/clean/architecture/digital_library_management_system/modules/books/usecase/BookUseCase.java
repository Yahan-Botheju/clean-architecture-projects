package lk.clean.architecture.digital_library_management_system.modules.books.usecase;

import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowResult;

public interface BookUseCase {

    //borrow book
    BookBorrowResult bookBorrow(BookBorrowCommand bookBorrowCommand);
}
