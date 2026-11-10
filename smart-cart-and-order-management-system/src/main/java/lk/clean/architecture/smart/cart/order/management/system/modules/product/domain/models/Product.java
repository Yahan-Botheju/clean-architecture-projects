package lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.models;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.enums.ProductStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Product {
    private final UUID productId;
    private String sku;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private ProductStatus productStatus;
    private LocalDateTime createdAt;

    public Product(UUID productId, String sku, String productName, String productDescription, BigDecimal productPrice, ProductStatus productStatus, LocalDateTime createdAt) {
        this.productId = productId;
        this.sku = sku;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.createdAt = createdAt;
    }

    /* __FACTORY_METHOD__ */
    public static Product createNewProduct(String sku, String productName, String productDescription, BigDecimal productPrice, ProductStatus productStatus, LocalDateTime createdAt) {
        return new Product(
                UUID.randomUUID(),
                sku,
                productName,
                productDescription,
                productPrice,
                productStatus,
                createdAt
        );
    }

    /* __LOGICS__ */


    //change product price
    public void changeProductPrice(BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be zero or negative");
        }
        this.productPrice = price;
    }

    //check product is inactive
    public void checkProductAvailability() {
        if(this.productStatus != ProductStatus.ACTIVE) {
            throw new IllegalArgumentException("Product must be ACTIVE to sell");
        }
    }
}
