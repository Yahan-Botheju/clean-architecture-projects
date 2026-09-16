package lk.clean.architecture.cart.system.ex02.modules.order.domain.modules;

import lombok.Getter;

import java.util.UUID;

@Getter
public class OrderItem {
    private final UUID productId;
    private String productName;
    private double unitPrice;
    private int quantity;

    public OrderItem(UUID productId, String productName, double unitPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    /* __DOMAIN_LOGIC__ */


    //get subtotal
    public double getItemSubTotal(){
        if(this.quantity <= 0 || this.unitPrice <= 0){
            throw new IllegalArgumentException("Please buy at least one item");
        }
        return this.unitPrice * this.quantity;
    }
}
