package lk.clean.architecture.digital_library_management_system.modules.users.usecase;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.models.User;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.repositories.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class UserDetailsApiImpl implements UserDetailsApi {

    //inject required dependencies
    private final UserRepository userRepository;

    public UserDetailsApiImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //user for other domain usage
    @Override
    public User sharedUserDetails(UUID userId) {
        User availableUser = userRepository.getUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userRepository.save(availableUser);
    }
}
