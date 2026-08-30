package lk.clean.architecture.digital_library_management_system.modules.books.web.webMappers;

import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowResult;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookBorrowRequestDTO;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookBorrowedResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookBorrowWebMapper {

    //to user command
    BookBorrowCommand toBookBorrowCommand(BookBorrowRequestDTO bookBorrowRequestDTO);

    //domain model to responseDTO
    BookBorrowedResponseDTO toBookBorrowResponseDTO(BookBorrowResult bookBorrowResult);
}
