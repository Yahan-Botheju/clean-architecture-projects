package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.persistenceMapper;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.models.Book;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.entities.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookPersistenceMapper{

    //domain model to entity
    BookEntity toEntity(Book book);

    //entity to domain model
    Book toDomainModel(BookEntity bookEntity);
}