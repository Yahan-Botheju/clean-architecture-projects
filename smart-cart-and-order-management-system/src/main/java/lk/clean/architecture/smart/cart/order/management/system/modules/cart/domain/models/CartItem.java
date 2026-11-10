package lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class CartItem {
    private final UUID cartItemId;
    private final UUID productId;
    private int quantity;
    private BigDecimal unitPrice;

    public CartItem(UUID cartItemId, UUID productId, int quantity, BigDecimal unitPrice) {
        this.cartItemId = cartItemId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }


    /* __FACTORY_METHOD__ */

    public static CartItem createNewCartItem(
            UUID productId,
            int quantity,
            BigDecimal unitPrice
    ) {
        return new CartItem(
                UUID.randomUUID(),
                productId,
                quantity,
                unitPrice
        );
    }



    /* __DOMAIN_LOGICS__ */


    //add quantity
    public void addQuantity(int extraQuantity) {
        if (extraQuantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.quantity += extraQuantity;
    }

    //replace the quantity
    public void replaceQuantity(int newQuantity) {
        if(newQuantity <= 0 || newQuantity >= 99){
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.quantity = newQuantity;
    }
}
