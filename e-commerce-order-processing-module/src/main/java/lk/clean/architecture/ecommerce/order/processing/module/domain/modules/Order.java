package lk.clean.architecture.ecommerce.order.processing.module.domain.modules;

import lk.clean.architecture.ecommerce.order.processing.module.domain.enums.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Order {
    private final UUID orderId;
    private final UUID customerId;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private String shippingAddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(UUID orderId, UUID customerId, BigDecimal totalAmount, OrderStatus status, String shippingAddress, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /* __DOMAIN_BUSSINESS_LOGICS__ */

    //create order
    public void createOrder(BigDecimal totalAmount, LocalDateTime currentTime){
        //check total amount grate than 0 or 0
        if(totalAmount == null || this.totalAmount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Total amount must be greater than zero");
        }
        //mutate the fields
        this.status = OrderStatus.PENDING;
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }
    //confirm order
    public void confirmOrder(LocalDateTime currentTime){
        //check order status is canceled
         if(this.status == OrderStatus.CANCELLED){
             throw new  IllegalArgumentException("Cancelled order cannot be confirmed");
         }
         //check order status is confirmed
         if(this.status == OrderStatus.CONFIRMED){
             throw  new  IllegalArgumentException("Already confirmed order cannot be confirmed");
         }
         //mutate the fields
         this.status = OrderStatus.CONFIRMED;
         this.updatedAt = currentTime;
    }
}
