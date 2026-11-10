package lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.enums.CustomerStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerRegisterResult(
         UUID customerId,
         String fullName,
         String email,
         CustomerStatus customerStatus,
         LocalDateTime createdAt
) {
}
