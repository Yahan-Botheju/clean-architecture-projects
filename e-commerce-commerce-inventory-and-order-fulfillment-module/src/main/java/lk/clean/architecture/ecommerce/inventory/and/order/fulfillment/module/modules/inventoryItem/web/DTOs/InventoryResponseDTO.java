package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.DTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record InventoryResponseDTO(
        UUID productId,
        String productName,
        int availableStock,
        int reservedStock,
        BigDecimal unitPrice,
        LocalDateTime updatedAt
) {}
