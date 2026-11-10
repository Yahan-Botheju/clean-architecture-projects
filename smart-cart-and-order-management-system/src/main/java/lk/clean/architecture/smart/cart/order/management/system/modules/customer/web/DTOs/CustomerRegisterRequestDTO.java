package lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterRequestDTO {

    @NotBlank(message = "Name cannot be empty")
    private String fullName;

    @Email
    @NotBlank(message = "Email cannot be empty")
    private String email;
}
