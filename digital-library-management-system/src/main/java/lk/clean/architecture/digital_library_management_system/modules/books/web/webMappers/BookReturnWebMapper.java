package lk.clean.architecture.digital_library_management_system.modules.books.web.webMappers;

import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowResult;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookReturnCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookReturnResult;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookReturnRequestDTO;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookReturnResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookReturnWebMapper {

    //requestDTO to command
    BookReturnCommand toBookReturnCommand(BookReturnRequestDTO bookReturnRequestDTO);

    //domain model to responseDTO
    BookReturnResponseDTO toBookReturnResponseDTO(BookReturnResult bookReturnResult);
}
