package lk.clean.architecture.cart.system.ex02.modules.cart.domain.models;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Cart {
    private final UUID cartId;
    private final UUID userId;
    private List<CartItem> items;
    private double totalPrice;

    public Cart(UUID cartId, UUID userId, List<CartItem> items, double totalPrice) {
        this.cartId = cartId;
        this.userId = userId;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    /* __FACTORY_METHOD__ */

    public Cart createNewCart(
            UUID userId,
            List<CartItem> items,
            double totalPrice

    ) {
        return  new Cart(
                UUID.randomUUID(),
                userId,
                items,
                totalPrice
        );
    }
}
