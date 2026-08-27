package lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.models.User;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.repositories.UserRepository;
import lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.jpa.JpaUserRepository;
import lk.clean.architecture.digital_library_management_system.modules.users.infrastructure.persistence.persistenceMapper.UserPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    //inject required dependencies
    private final JpaUserRepository jpaUserRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    public UserRepositoryImpl(
            JpaUserRepository jpaUserRepository,
            UserPersistenceMapper userPersistenceMapper
    ) {
        this.jpaUserRepository = jpaUserRepository;
        this.userPersistenceMapper = userPersistenceMapper;
    }

    //get user by id
    @Override
    public Optional<User> getUserById(UUID userId) {
        return jpaUserRepository.findById(userId)
                .map(userPersistenceMapper::toDomainModel);
    }
}
