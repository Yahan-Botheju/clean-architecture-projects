package lk.clean.architecture.digital_library_management_system.modules.users.usecase;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.repositories.UserRepository;

public class UserDetailsApiImpl implements UserDetailsApi {

    //inject required dependencies
    private final UserRepository userRepository;

    public UserDetailsApiImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
