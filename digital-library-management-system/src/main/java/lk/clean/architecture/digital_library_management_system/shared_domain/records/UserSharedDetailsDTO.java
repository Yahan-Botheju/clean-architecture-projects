package lk.clean.architecture.digital_library_management_system.shared_domain.records;

import lk.clean.architecture.digital_library_management_system.modules.users.domain.enums.UserStatus;

import java.util.UUID;

public record UserSharedDetailsDTO(
        UUID userId,
        String userName,
        String email,
        UserStatus status,
        int activeBookCount
) {}
