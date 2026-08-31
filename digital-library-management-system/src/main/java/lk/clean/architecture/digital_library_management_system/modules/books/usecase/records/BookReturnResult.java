package lk.clean.architecture.digital_library_management_system.modules.books.usecase.records;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BorrowStatus;

import java.util.UUID;

public record BookReturnResult(
        UUID bookId,
        String title,
        UUID userId,
        String isbn,
        BookStatus status,
        BorrowStatus borrowStatus
) {}
