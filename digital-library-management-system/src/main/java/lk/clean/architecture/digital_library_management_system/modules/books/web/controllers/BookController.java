package lk.clean.architecture.digital_library_management_system.modules.books.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.BookBorrowUseCase;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.BookReturnUseCase;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowResult;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookReturnCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookBorrowRequestDTO;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookBorrowedResponseDTO;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookReturnRequestDTO;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookReturnResponseDTO;
import lk.clean.architecture.digital_library_management_system.modules.books.web.webMappers.BookBorrowWebMapper;
import lk.clean.architecture.digital_library_management_system.modules.books.web.webMappers.BookReturnWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class BookController {

    //inject required dependencies
    private final BookBorrowUseCase bookBorrowUseCase;
    private final BookReturnUseCase bookReturnUseCase;
    private final BookBorrowWebMapper bookBorrowWebMapper;
    private final BookReturnWebMapper bookReturnWebMapper;


    public BookController(
            BookBorrowUseCase bookBorrowUseCase,
            BookReturnUseCase bookReturnUseCase,
            BookBorrowWebMapper bookBorrowWebMapper,
            BookReturnWebMapper bookReturnWebMapper
    ) {
        this.bookBorrowUseCase = bookBorrowUseCase;
        this.bookReturnUseCase = bookReturnUseCase;
        this.bookBorrowWebMapper = bookBorrowWebMapper;
        this.bookReturnWebMapper = bookReturnWebMapper;
    }

    //borrow a book endpoint
    @PostMapping("/borrowings")
    public ResponseEntity<BookBorrowedResponseDTO>  borrowBook(
            @Valid BookBorrowRequestDTO bookBorrowRequestDTO
    ){
        //dto -> command
        BookBorrowCommand toBorrowCommand = bookBorrowWebMapper.toBookBorrowCommand(bookBorrowRequestDTO);
        //command -> usecase
        BookBorrowResult toUseCase = bookBorrowUseCase.bookBorrow(toBorrowCommand);
        //command -> response
        BookBorrowedResponseDTO responseDTO = bookBorrowWebMapper.toBookBorrowResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    //book return endpoint
    @PostMapping("/borrowings/return")
    public ResponseEntity<BookReturnResponseDTO>  returnBook(
            @Valid @RequestBody BookReturnRequestDTO bookReturnRequestDTO
    ){
        BookReturnCommand toReturnCommand =
    }
}
