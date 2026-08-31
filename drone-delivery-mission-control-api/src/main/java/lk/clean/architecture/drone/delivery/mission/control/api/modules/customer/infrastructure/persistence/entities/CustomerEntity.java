package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_email", nullable = false, unique = true)
    private String customerEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status", nullable = false)
    private CustomerStatus customerStatus;
}
