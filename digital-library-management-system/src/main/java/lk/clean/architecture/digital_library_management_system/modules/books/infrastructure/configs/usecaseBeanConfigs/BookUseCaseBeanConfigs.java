package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.configs.usecaseBeanConfigs;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.repositories.BookRepository;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.BookUseCase;
import lk.clean.architecture.digital_library_management_system.modules.books.usecase.BookUseCaseImpl;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookUseCaseBeanConfigs {

    //book usecase bean config
    @Bean
    public BookUseCase bookUseCase(
            BookRepository bookRepository,
            UserDetailsApi userDetailsApi
    ) {
        return new BookUseCaseImpl(bookRepository, userDetailsApi);
    }
}
