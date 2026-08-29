package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.configs.usecaseBeanConfigs;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.BookBorrowUseCase;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.BookBorrowUseCaseImpl;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookUseCaseBeanConfigs {

    //book usecase bean config
    @Bean
    public BookBorrowUseCase bookUseCase(
            BookRepository bookRepository,
            UserDetailsApi userDetailsApi
    ) {
        return new BookBorrowUseCaseImpl(bookRepository, userDetailsApi);
    }
}
