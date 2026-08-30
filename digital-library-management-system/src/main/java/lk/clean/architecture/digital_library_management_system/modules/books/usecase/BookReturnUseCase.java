package lk.clean.architecture.digital_library_management_system.modules.books.usecase;

import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookReturnCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookReturnResult;

public interface BookReturnUseCase {

    //return a book
    BookReturnResult returnBook(BookReturnCommand bookReturnCommand);
}
