package lk.clean.architecture.digital_library_management_system.modules.users.usecase;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.api.UserDetailsApi;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.models.User;
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

    /* __PRIVATE_METHODS__ */

    //private method get user
    private User getUser(UUID userId) {
        return userRepository.getUserById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User not found!" + ", " +  userId));
    }


    /* __PUBLIC_METHODS__ */


    //user for other domain usage through record class
    @Override
    public UserSharedDetailsDTO sharedUserDetails(UUID userId) {

        User newUser = getUser(userId);

        return new UserSharedDetailsDTO(
                        newUser.getUserId(),
                        newUser.getUserName(),
                        newUser.getEmail(),
                        newUser.getStatus());
    }

    //check user activation
    @Override
    public void checkUserActivation(UUID userId) {
        //get related user
        User getUser = getUser(userId);
        //check user activation
        getUser.checkUserActivation();
    }

    //borrow book
    public void borrowBookByUser(){
        User get
    }
}
