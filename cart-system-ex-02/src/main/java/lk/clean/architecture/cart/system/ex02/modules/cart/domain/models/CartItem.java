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
}
