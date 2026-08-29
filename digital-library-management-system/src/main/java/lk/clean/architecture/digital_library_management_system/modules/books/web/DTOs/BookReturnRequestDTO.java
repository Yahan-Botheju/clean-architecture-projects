package lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReturnRequestDTO {
    private UUID userId;
    private UUID bookId;
}
