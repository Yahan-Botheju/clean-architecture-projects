package lk.clean.architecture.digital_library_management_system.modules.users.domain.api;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.models.User;

import java.util.UUID;

public interface UserDetailsApi {

    //user details for external domain usage
    User sharedUserDetails(UUID userId);
}
