package lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories;


import lk.clean.architecture.digital_library_management_system.modules.books.domain.models.Book;

import java.util.UUID;

public interface BookRepository {

    //check book existence
    boolean existsById(UUID bookId);

    //get book by id
    Book getBookById(UUID bookId);
}
