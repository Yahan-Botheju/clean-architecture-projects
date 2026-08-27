package lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.configs.persistenceBeanConfigs;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.repositories.UserRepository;
import lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.UserRepositoryImpl;
import lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.jpa.JpaUserRepository;
import lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.persistenceMapper.UserPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {

    //user persistence impl
    @Bean
    public UserRepository userRepository(
            JpaUserRepository jpaUserRepository,
            UserPersistenceMapper userPersistenceMapper
    ) {
        return new UserRepositoryImpl(jpaUserRepository, userPersistenceMapper);
    }
}
