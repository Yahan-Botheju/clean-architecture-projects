package lk.clean.architecture.digital_library_management_system.modules.books.web.webMappers;

import lk.clean.architecture.digital_library_management_system.modules.books.usecase.records.BookBorrowCommand;
import lk.clean.architecture.digital_library_management_system.modules.books.web.DTOs.BookBorrowRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserWebMapper {

    //to user command
    BookBorrowCommand toBookBorrowCommand(BookBorrowRequestDTO bookBorrowRequestDTO);
}
