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
}
