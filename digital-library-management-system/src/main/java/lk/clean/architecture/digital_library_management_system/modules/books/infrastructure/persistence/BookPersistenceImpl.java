package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.jpa.JpaBookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.persistenceMapper.BookPersistenceMapper;

import java.util.UUID;

public class BookPersistenceImpl implements BookRepository {

    //inject required dependencies
    private final JpaBookRepository jpaBookRepository;
    private final BookPersistenceMapper bookPersistenceMapper;

    public BookPersistenceImpl(
            JpaBookRepository jpaBookRepository,
            BookPersistenceMapper bookPersistenceMapper
    ) {
        this.jpaBookRepository = jpaBookRepository;
        this.bookPersistenceMapper = bookPersistenceMapper;
    }

    //check book by id
    @Override
    public boolean existsById(UUID bookId) {
        return jpaBookRepository.existsById(bookId);
    }

}
