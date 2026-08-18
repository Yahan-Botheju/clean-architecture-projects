package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.enums.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Order {
    private final UUID orderId;
    private final UUID customerId;
    private final UUID productId;
    private int orderQuantity;
    private BigDecimal totalPrice;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(UUID orderId, UUID customerId, UUID productId, int orderQuantity, BigDecimal totalPrice, OrderStatus orderStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.orderQuantity = orderQuantity;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /* __DOMAIN_BUSINESS_LOGICS__ */

    //order creation check
    public void createOrderCheck(LocalDateTime currentTime){
        //check order quantity > 0 OR price > 0
        if(this.orderQuantity <= 0 || this.totalPrice == null || this.totalPrice.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalStateException("Order quantity and total price must be greater than 0");
        }
        //mutate value
        this.orderStatus = OrderStatus.PENDING;
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }


}
