package lk.clean.architecture.digital_library_management_system.modules.books.usecase.records;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;

import java.time.LocalDate;
import java.util.UUID;

public record BookBorrowResult(
        UUID bookId,
        UUID borrowedByUserId,
        String isbn,
        String title,
        String author,
        LocalDate borrowedDate,
        LocalDate dueDate,
        BookStatus bookStatus
) {}
