package lk.clean.architecture.cart.system.ex02.modules.order.domain.modules;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.enums.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private final UUID orderId;
    private final UUID userId;
    private double totalAmount;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;

    private Order(UUID orderId, UUID userId,  List<OrderItem> orderItems, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderItems = orderItems;
        this.createdAt = createdAt;
    }


    /* __DOMAIN_LOGIC__ */

    //create order
    public static Order createOrder(UUID userId, List<OrderItem> orderItems, LocalDateTime currentTime) {
        //check order item is empty
        if(orderItems.isEmpty()){
            throw new IllegalArgumentException("Order items cannot be empty");
        }
        //set all subtotal into total amount

        //set order status as pending
         Order createNewOrder = new Order(UUID.randomUUID(), userId, orderItems,  currentTime);
         createNewOrder.totalAmount =  orderItems.stream().mapToDouble(OrderItem::getItemSubTotal).sum();
         createNewOrder.orderStatus = OrderStatus.PENDING;
         createNewOrder.createdAt = currentTime;

         return createNewOrder;
    }

    //confirm order
    public void confirmOrder(){
        //check order status is required state
        if(this.orderStatus != OrderStatus.PENDING){
            throw new IllegalStateException("Order status must be PENDING");
        }
        //set to confirmed
        this.orderStatus = OrderStatus.CONFIRMED;
    }

    //cancel order
    public void cancelOrder(){
        //check order
        if(this.orderStatus != OrderStatus.CONFIRMED && this.orderStatus != OrderStatus.CANCELLED){
            throw new IllegalStateException("Order is not in correct state to be cancelled");
        }
        this.orderStatus = OrderStatus.CANCELLED;
    }
}
