package lk.clean.architecture.cart.system.ex02.modules.cart.domain.models;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CartItem {
    private final UUID productId;
    private String productName;
    private double unitPrice;
    private int quantity;

    public CartItem(UUID productId, String productName, double unitPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    /* __FACTORY_METHOD__ */
    public CartItem createNewCartItem(
            String productName,
            double unitPrice,
            int quantity
    ){
        return new CartItem(
                UUID.randomUUID(),
                productName,
                unitPrice,
                quantity
        );
    }

    /* __DOMAIN_LOGICS__ */

    //update quantity
    public void updateQuantity(int newQuantity){
        if(newQuantity <= 0){
            throw new IllegalArgumentException("Quantity cannot be empty or 0");
        }
        this.quantity = newQuantity;
    }
}
