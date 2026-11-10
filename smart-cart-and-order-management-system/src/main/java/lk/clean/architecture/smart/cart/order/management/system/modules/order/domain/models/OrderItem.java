package lk.clean.architecture.smart.cart.order.management.system.modules.order.domain.models;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class OrderItem {
    private final UUID orderItemId;
    private final UUID productId;
    private String productName;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal subTotal;

    public OrderItem(UUID orderItemId, UUID productId, String productName, BigDecimal unitPrice, int quantity) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    /* __DOMAIN_LOGIC__ */

    public void calculateSubTotalOfOrderItem() {
        //check quantity
        if(this.quantity <= 0 || this.unitPrice.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalStateException("Cannot proceed order due to required fields are not in correct state");
        }
        this.subTotal = this.unitPrice.multiply(new BigDecimal(this.quantity));
    }

}
