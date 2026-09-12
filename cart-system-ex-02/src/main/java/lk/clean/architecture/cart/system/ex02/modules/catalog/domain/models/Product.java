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


    //check enough stock is available
    public void enoughStockAvailable(int quantity) {
        if(this.stockQuantity < quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }
    }

    //check enough stock available for buy
    public void deductStock(int requestedQuantity) {
        //check request quantity not empty
        if(requestedQuantity <= 0){
            throw new IllegalArgumentException("Requested quantity must be greater than zero");
        }
        //check stock available
        if(this.stockQuantity < requestedQuantity){
            throw  new IllegalArgumentException("Not enough stock available");
        }
        //mutate the available stock
        this.stockQuantity -= requestedQuantity;

        //no available stock, set to OUT_OF_STOCK
        if(this.stockQuantity == 0){
            this.productStatus = ProductStatus.OUT_OF_STOCK;
        }
    }

    //add new quantity for stock
    public void replenishStock(int addNewQuantity) {
        //check req.quantity is empty
        if(addNewQuantity <= 0){
            throw new IllegalArgumentException("Added quantity must be greater than zero");
        }
        //add quantity
        this.stockQuantity += addNewQuantity;
        //if product status OUT_OF_STOCK, then set it into ACTIVE
        if(this.productStatus == ProductStatus.OUT_OF_STOCK){
            this.productStatus = ProductStatus.ACTIVE;
        }
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
