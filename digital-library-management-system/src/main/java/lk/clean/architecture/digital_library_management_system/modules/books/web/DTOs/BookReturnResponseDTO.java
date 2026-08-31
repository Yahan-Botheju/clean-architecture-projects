package lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BorrowStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReturnResponseDTO {
    private UUID bookId;
    private String title;
    private UUID userId;
    private String isbn;
    private BookStatus status;
    private BorrowStatus borrowStatus;
}
