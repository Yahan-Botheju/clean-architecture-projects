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



    /* __DOMAIN_LOGIC__ */


    //check enough stock available for buy
    public void hasEnoughStock(int requestedQuantity) {
        if(this.stockQuantity < requestedQuantity){
            throw  new IllegalArgumentException("Not enough stock available");
        }
        this.stockQuantity -= requestedQuantity;
    }

    //add new quantity for stock
    public void replenishStock(int addNewQuantity) {
        this.stockQuantity += addNewQuantity;
    }

    //product DISCONTINUED
    public void deactivateProduct() {
        if(this.productStatus != ProductStatus.ACTIVE
            && this.productStatus != ProductStatus.OUT_OF_STOCK
        ){
            throw  new IllegalArgumentException("Product is not in required state to DISCONTINUED");
        }
        this.productStatus = ProductStatus.DISCONTINUED;
    }
}
