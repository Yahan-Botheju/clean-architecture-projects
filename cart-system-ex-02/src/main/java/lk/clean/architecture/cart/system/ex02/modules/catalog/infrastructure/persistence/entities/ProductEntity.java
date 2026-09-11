package lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

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

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_status", nullable = false)
    private ProductStatus productStatus;
}
