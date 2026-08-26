package lk.clean.architecture.digital_library_management_system.modules.books.web.controllers;

import lk.clean.architecture.digital_library_management_system.modules.books.usecase.BookUseCase;
import lk.clean.architecture.digital_library_management_system.modules.books.web.webMappers.BookWebMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class BookController {

    //inject required dependencies
    private final BookUseCase bookUseCase;
    private final BookWebMapper bookWebMapper;

    public BookController(BookUseCase bookUseCase, BookWebMapper bookWebMapper) {
        this.bookUseCase = bookUseCase;
        this.bookWebMapper = bookWebMapper;
    }
}
