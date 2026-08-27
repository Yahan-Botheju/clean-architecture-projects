package lk.clean.architecture.digital_library_management_system.modules.users.domain.api;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.models.User;
import lk.clean.architecture.digital_library_management_system.shared_domain.records.UserSharedDetailsDTO;

import java.util.UUID;

public interface UserDetailsApi {

    //user details for external domain usage
    UserSharedDetailsDTO sharedUserDetails(UUID userId);
}
