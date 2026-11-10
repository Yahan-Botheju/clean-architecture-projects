package lk.clean.architecture.smart.cart.order.management.system.modules.inventory.domain.models;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Inventory {
    private final UUID inventoryId;
    private final UUID productId;
    private int availableQuantity;
    private int reservedQuantity;
    private LocalDateTime updatedAt;

    public Inventory(UUID inventoryId, UUID productId, int availableQuantity, int reservedQuantity, LocalDateTime updatedAt) {
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.availableQuantity = availableQuantity;
        this.reservedQuantity = reservedQuantity;
        this.updatedAt = updatedAt;
    }

    /* __DOMAIN_LOGIC__ */

    //add stock
    public void addStock(int addNewQuantity) {
        if(addNewQuantity < 0){
            throw new IllegalArgumentException("Add quantity cannot be zero");
        }
       this.availableQuantity += addNewQuantity;
    }


    //reserve stock
    public void reserveStock(int requestedQuantity) {
        if(this.availableQuantity < requestedQuantity) {
            throw new IllegalStateException("Insufficient resource in stock");
        }

        this.availableQuantity -= requestedQuantity;
        this.reservedQuantity += requestedQuantity;
    }

    //release stock
    public void releaseStock(int requestedQuantity) {
        if(this.reservedQuantity <= 0) {
            throw new IllegalStateException("No reservation items to cancel the order");
        }
        this.availableQuantity += this.reservedQuantity;
        this.reservedQuantity -= this.reservedQuantity;
    }
}
