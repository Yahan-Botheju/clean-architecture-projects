package lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.entities;

import jakarta.persistence.*;
import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carts")
@SoftDelete(columnName = "is_deleted")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    @Id
    @Column(name = "cart_id", nullable = false, unique = true)
    private UUID cartId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private List<CartItemEntity> cartItems = new ArrayList<>();

    @Column(name = "total_price")
    private double totalPrice;
}
