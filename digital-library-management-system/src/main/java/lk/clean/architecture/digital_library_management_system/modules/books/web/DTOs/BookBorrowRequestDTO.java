package lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowRequestDTO {

    @NotNull(message = "Book ID is required")
    private UUID bookId;

    @NotNull(message = "User ID is required")
    private UUID userId;

    @NotBlank(message = "Book title cannot be empty")
    private String title;

    @NotBlank(message = "Author name cannot be empty")
    private String author;
}
