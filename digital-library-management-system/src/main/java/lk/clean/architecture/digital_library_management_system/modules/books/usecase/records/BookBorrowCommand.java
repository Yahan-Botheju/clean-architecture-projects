package lk.clean.architecture.digital_library_management_system.modules.books.usecase.records;

import java.util.UUID;

public record BookBorrowCommand(
        UUID userId,
        String title,
        String author
) {
}
