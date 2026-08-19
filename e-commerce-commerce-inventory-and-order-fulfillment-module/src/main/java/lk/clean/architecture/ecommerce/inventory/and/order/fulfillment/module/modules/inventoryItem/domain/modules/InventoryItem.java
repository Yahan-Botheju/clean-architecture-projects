package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.enums.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class InventoryItem {
    private final UUID productId;
    private String productName;
    private int availableStock;
    private BigDecimal unitPrice;
    private int reservedStock;
    private LocalDateTime updatedAt;

    public InventoryItem(UUID productId, String productName, int availableStock, BigDecimal unitPrice, int reservedStock, LocalDateTime updatedAt) {
        this.productId = productId;
        this.productName = productName;
        this.availableStock = availableStock;
        this.unitPrice = unitPrice;
        this.reservedStock  = reservedStock;
        this.updatedAt = updatedAt;
    }

     /* __DOMAIN_BUSINESS_LOGICS__ */
    //stock reservation
    public void stockReservation(int requestedQuantity, LocalDateTime currentTime) {
        if(this.availableStock < requestedQuantity) {
            throw new IllegalStateException("Available stock is too low" + requestedQuantity);
        }
        this.availableStock -= requestedQuantity;
        this.reservedStock += requestedQuantity;
        this.updatedAt = currentTime;
    }
}
