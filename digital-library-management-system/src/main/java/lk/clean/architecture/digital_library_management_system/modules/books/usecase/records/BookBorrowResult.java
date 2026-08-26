package lk.clean.architecture.digital_library_management_system.modules.books.usecase.records;

import java.util.UUID;

public record BookBorrowResult(
        UUID bookId,
        UUID borrowedByUserId,
        String isbn,
        String title,
        String author
) {}
