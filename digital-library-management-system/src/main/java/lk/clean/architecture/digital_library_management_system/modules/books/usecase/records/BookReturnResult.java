package lk.clean.architecture.digital_library_management_system.modules.books.usecase.records;

import java.util.UUID;

public record BookReturnResult(
        UUID bookId,
        String title,
        UUID userId,
        String userName,
        String email,
        String isbn
) {}
