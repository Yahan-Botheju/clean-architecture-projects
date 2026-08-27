package lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories;


import java.util.UUID;

public interface BookRepository {

    //check book existence
    boolean existsById(UUID bookId);
}
