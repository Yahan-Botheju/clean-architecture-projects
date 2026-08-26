package lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.configs.usecaseBeanConfigs;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.repositories.UserRepository;
import lk.clean.architecture.digital_library_management_system.modules.users.usecase.UserDetailsApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //external usage
    @Bean
    public UserDetailsApi userDetailsApi(
            UserRepository userRepository
    ) {
        return new UserDetailsApiImpl(userRepository);
    }
}
