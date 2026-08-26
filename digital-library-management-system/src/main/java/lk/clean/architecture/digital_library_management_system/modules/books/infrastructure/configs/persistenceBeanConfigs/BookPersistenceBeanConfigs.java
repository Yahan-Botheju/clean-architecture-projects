package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.configs.persistenceBeanConfigs;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.BookPersistenceImpl;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.jpa.JpaBookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.persistenceMapper.BookPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookPersistenceBeanConfigs {

    //book persistence bean config
    @Bean
    public BookRepository bookRepository(
            JpaBookRepository jpaBookRepository,
            BookPersistenceMapper bookPersistenceMapper
    ) {
        return new BookPersistenceImpl(jpaBookRepository, bookPersistenceMapper);
    }
}
