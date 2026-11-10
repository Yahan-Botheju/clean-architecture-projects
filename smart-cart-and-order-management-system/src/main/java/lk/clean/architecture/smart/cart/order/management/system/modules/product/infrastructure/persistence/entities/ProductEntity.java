package lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
@SoftDelete(columnName = "is_deleted")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "product_id", nullable = false, unique = true)
    private UUID productId;

    @Column(name = "product_sku", nullable = false, unique = true)
    private String sku;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    private BigDecimal productPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_status", nullable = false)
    private ProductStatus productStatus;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
