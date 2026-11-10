package lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.DTOs;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterResponseDTO {
    private UUID customerId;
    private String fullName;
    private String email;
    private CustomerStatus customerStatus;
    private LocalDateTime createdAt;
}
