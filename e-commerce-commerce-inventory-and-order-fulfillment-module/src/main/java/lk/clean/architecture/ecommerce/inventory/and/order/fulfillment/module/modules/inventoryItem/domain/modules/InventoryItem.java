package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules;

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
}
