package lk.clean.architecture.digital_library_management_system.modules.books.usecase;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;

public class BookReturnUseCaseImpl implements BookReturnUseCase {

    //inject required dependencies
    private final BookRepository bookRepository;

    public BookReturnUseCaseImpl(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

}
