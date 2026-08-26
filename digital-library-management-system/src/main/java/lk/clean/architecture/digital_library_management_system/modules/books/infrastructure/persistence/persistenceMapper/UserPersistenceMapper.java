package lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.persistenceMapper;

import lk.clean.architecture.digital_library_management_system.modules.books.infrastructure.persistence.entities.UserEntity;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.models.User;

public interface UserPersistenceMapper {

    //domain model to entity
    UserEntity toEntity(User user);

    //entity to domain model
    User toDomainModel(UserEntity userEntity);
}
