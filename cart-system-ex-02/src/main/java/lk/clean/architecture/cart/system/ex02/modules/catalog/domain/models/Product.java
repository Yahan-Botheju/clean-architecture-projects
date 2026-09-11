package lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.enums.ProductStatus;

import java.util.UUID;

public class Product {
    private final UUID productId;
    private String productName;
    private double unitPrice;
    private int stockQuantity;
    private ProductStatus productStatus;

    public Product(UUID productId, String productName, double unitPrice, int stockQuantity, ProductStatus productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
        this.productStatus = productStatus;
    }

    public UUID getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getUnitPrice() { return unitPrice; }
    public int getStockQuantity() { return stockQuantity; }
    public ProductStatus getProductStatus() { return productStatus; }




}
