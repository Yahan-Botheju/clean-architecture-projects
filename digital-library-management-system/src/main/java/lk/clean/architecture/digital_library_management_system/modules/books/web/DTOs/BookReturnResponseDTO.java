package lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs;

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
    private String status;
    private String borrowStatus;
}
