package lk.clean.architecture.smart.cart.order.management.system.shared_domain.customer_shared_api;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.enums.CustomerStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record CheckCustomerApiResult(
        UUID customerId,
        String fullName,
        String email,
        CustomerStatus customerStatus,
        LocalDateTime createdAt
) {
}
