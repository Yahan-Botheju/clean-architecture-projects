package lk.clean.architecture.digital_library_management_system.modules.users.domain.repositories;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    //get user by id
    Optional<User> getUserById(UUID id);
}
