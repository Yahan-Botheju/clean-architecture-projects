package lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customers")
@SoftDelete(columnName = "is_deleted")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @Column(name = "customer_id", nullable = false, unique = true)
    private UUID customerId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status", nullable = false)
    private CustomerStatus customerStatus;

    private LocalDateTime createdAt;
}
