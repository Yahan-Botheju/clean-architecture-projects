package lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowedResponseDTO {
    private UUID bookId;
    private UUID borrowedByUserId;
    private String isbn;
    private String title;
    private String author;
}
