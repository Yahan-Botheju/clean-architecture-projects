package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface InventoryModuleApi {

    //RESERVATION METHOD FOR EXTERNAL METHOD USAGE
    public void stockReservation(UUID productId, int requestedQuantity,  LocalDateTime currentTime);

    //unite price
    BigDecimal getUnitPrice(UUID productId);
}
