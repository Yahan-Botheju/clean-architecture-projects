package lk.clean.architecture.ecommerce.order.processing.module.web.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    @NotNull(message = "Customer ID cannot be empty")
    private UUID customerId;

    @NotNull(message = "Total amount cannot be empty")
    private BigDecimal totalAmount;

    private String shippingAddress;
}
