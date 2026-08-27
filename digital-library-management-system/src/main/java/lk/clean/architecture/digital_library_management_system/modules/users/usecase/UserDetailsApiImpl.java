package lk.clean.architecture.digital_library_management_system.modules.users.usecase;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.repositories.UserRepository;
import lk.clean.architecture.digital_library_management_system.shared_domain.records.UserSharedDetailsDTO;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class UserDetailsApiImpl implements UserDetailsApi {

    //inject required dependencies
    private final UserRepository userRepository;

    public UserDetailsApiImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //user for other domain usage through record class
    @Override
    public UserSharedDetailsDTO sharedUserDetails(UUID userId) {
        return userRepository.getUserById(userId)
                .map(user -> new UserSharedDetailsDTO(
                        user.getUserId(),
                        user.getUserName(),
                        user.getEmail(),
                        user.getStatus()
                )).orElseThrow(() ->  new ResourceNotFoundException("User not found"));
    }
}
