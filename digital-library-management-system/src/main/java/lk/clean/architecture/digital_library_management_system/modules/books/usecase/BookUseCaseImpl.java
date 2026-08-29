package lk.clean.architecture.digital_library_management_system.modules.books.usecase;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.models.Book;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowResult;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;
import lk.clean.architecture.digital_library_management_system.shared_domain.records.UserSharedDetailsDTO;

public class BookUseCaseImpl implements BookUseCase {

    //inject required dependencies
    private final BookRepository bookRepository;
    private final UserDetailsApi userDetailsApi;

    public BookUseCaseImpl(BookRepository bookRepository, UserDetailsApi userDetailsApi) {
        this.bookRepository = bookRepository;
        this.userDetailsApi = userDetailsApi;
    }

    //borrow a book
    @Override
    public BookBorrowResult bookBorrow(BookBorrowCommand bookBorrowCommand){
        //user external api for get user
        UserSharedDetailsDTO getUser = userDetailsApi.sharedUserDetails(bookBorrowCommand.userId());

        //check user activation through user domain
        userDetailsApi.checkUserActivation(getUser.userId());

        //check user borrowed book count
        userDetailsApi.borrowBookByUser(getUser.userId());

        //check user has borrow the same book
        if(bookRepository.checkUserBorrowedBooks(bookBorrowCommand.userId(), bookBorrowCommand.title())){
            throw new IllegalStateException("User has already been borrowed this book");
        }

        //get book
        Book getBook = bookRepository.getBookById(bookBorrowCommand.bookId());

        //check book availability
        getBook.borrowBook(bookBorrowCommand.bookId());

        //save book
        Book savedBook = bookRepository.saveBorrowBook(getBook);

        return new BookBorrowResult(
                savedBook.getBookId(),
                savedBook.getUserId(),
                savedBook.getIsbn(),
                savedBook.getTitle(),
                savedBook.getAuthor()
        );
    }
}
