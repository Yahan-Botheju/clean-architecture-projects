package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.models.Book;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.entities.BookEntity;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.jpa.JpaBookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.persistenceMapper.BookPersistenceMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

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

    //get book by id
    @Override
    public Book getBookById(UUID bookId){
       return jpaBookRepository.findById(bookId)
               .map(bookPersistenceMapper::toDomainModel)
               .orElseThrow(() ->  new ResourceNotFoundException("Book not found"));
    }

    //save borrow book
    @Override
    public Book saveBorrowBook(Book book){
        BookEntity toEntity = bookPersistenceMapper.toEntity(book);
        BookEntity savedEntity = jpaBookRepository.save(toEntity);

        return bookPersistenceMapper.toDomainModel(savedEntity);
    }

    //check user going to borrow same book
    @Override
    public boolean checkUserBorrowedBooks(UUID userId, UUID bookId) {

        BookEntity checkBookExistence = jpaBookRepository.findById(bookId)
                .orElseThrow(() ->  new ResourceNotFoundException("Book not found"));

        return jpaBookRepository.checkUserBorrowedBooks(userId, checkBookExistence.getTitle());
    }

    //find borrow record and remove
    @Override
    public Book findBorrowedBookRecord(UUID userId, UUID bookId) {

        BookEntity checkBorrowBookExistence = jpaBookRepository.findByBookIdAndBorrowedByUserId(bookId, userId)
                .orElseThrow(() ->  new ResourceNotFoundException("Book not found"));

        return bookPersistenceMapper.toDomainModel(checkBorrowBookExistence);
    }

}
