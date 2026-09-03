package lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.enums.CustomerStatus;

import java.util.UUID;

public record CustomerCheckApiDTO(
        UUID customerId,
        String customerName,
        String customerEmail,
        CustomerStatus customerStatus
) {}
