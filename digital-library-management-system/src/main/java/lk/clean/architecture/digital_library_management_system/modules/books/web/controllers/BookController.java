package lk.clean.architecture.digital_library_management_system.modules.books.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.BookBorrowUseCase;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowResult;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookBorrowRequestDTO;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookBorrowedResponseDTO;
import lk.clean.architecture.digital_library_management_system.modules.books.web.webMappers.BookBorrowWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class BookController {

    //inject required dependencies
    private final BookBorrowUseCase bookBorrowUseCase;
    private final BookBorrowWebMapper bookBorrowWebMapper;

    public BookController(BookBorrowUseCase bookBorrowUseCase, BookBorrowWebMapper bookBorrowWebMapper) {
        this.bookBorrowUseCase = bookBorrowUseCase;
        this.bookBorrowWebMapper = bookBorrowWebMapper;
    }

    //borrow a book
    @PostMapping
    public ResponseEntity<BookBorrowedResponseDTO>  borrowBook(
            @Valid BookBorrowRequestDTO bookBorrowRequestDTO
    ){
        //dto -> command
        BookBorrowCommand toBorrowCommand = bookBorrowWebMapper.toBookBorrowCommand(bookBorrowRequestDTO);
        //command -> usecase
        BookBorrowResult toUseCase = bookBorrowUseCase.bookBorrow(toBorrowCommand);
        //command -> response
        BookBorrowedResponseDTO responseDTO = bookBorrowWebMapper.toBookBorrowResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDTO);
    }
}
