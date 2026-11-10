package lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.enums.CartStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
public class Cart {
    private final UUID cartId;
    private UUID customerId;
    private CartStatus cartStatus;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private final List<CartItem> cartItems = new ArrayList<>();

    public Cart(UUID cartId, UUID customerId, CartStatus cartStatus, BigDecimal totalAmount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.cartStatus = cartStatus;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /* __FACTORY_METHOD__ */

    public static Cart createNewCart(
              UUID customerId,
         BigDecimal totalAmount,
         LocalDateTime createdAt,
         LocalDateTime updatedAt
    ) {
        return new Cart(UUID.randomUUID(), customerId, CartStatus.ACTIVE, totalAmount, createdAt, updatedAt);
    }


    /* __DOMAIN_LOGICS__ */



    //add item
    public void addItem(UUID productId, int addQuantity, BigDecimal unitPrice, LocalDateTime currentTime) {
        //check cart is ACTIVE
        if (this.cartStatus != CartStatus.ACTIVE) {
            throw new IllegalStateException("Cart is not in active state");
        }
        //check incoming quantity
        if (addQuantity < 1 || addQuantity > 99) {
            throw new IllegalStateException("At least one item is required");
        }

        //check cart item has the product id
        Optional<CartItem> existingItem = this.cartItems.stream().filter(
                cartItem -> cartItem.getProductId().equals(productId)).findFirst();

        //if product is available, add quantity if not create new cart item
        if (existingItem.isPresent()) {
            existingItem.get().addQuantity(addQuantity);
            this.updatedAt = currentTime;
        } else {
            CartItem newCartItem = CartItem.createNewCartItem(productId, addQuantity, unitPrice);
            this.cartItems.add(newCartItem);
            this.createdAt = currentTime;
        }


    }


    //change item quantity
    public void changeItemQuantity(UUID cartItemId, UUID productId, int changeQuantity, LocalDateTime currentTime) {
        if(this.cartStatus != CartStatus.ACTIVE) {
            throw new IllegalStateException("Cart is not in active state, unable to continue the process");
        }

        //check product is available
        boolean isNoProduct = cartItems.stream()
                .anyMatch(cartItem -> cartItem.getProductId().equals(productId));

        if(!isNoProduct) {
            throw  new IllegalStateException("Product is not available in cart");
        }

        //check requested quantity in approve state
        if(changeQuantity < 1 || changeQuantity > 99) {
            throw new IllegalStateException("Invalid quantity request, unable to proceed");
        }

        //check cart item id is available
        boolean isCartItemId =  cartItems.stream()
                .anyMatch(checkCartItemId -> checkCartItemId.getCartItemId().equals(cartItemId) );

        if(!isCartItemId) {
            throw  new IllegalStateException("Cart item id is not available in cart");
        }

        //get item related to cart id and product id
        CartItem existingItems = cartItems.stream()
                .filter(items -> items.getProductId().equals(productId) && items.getCartItemId().equals(cartItemId)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        //mutate the event
        existingItems.replaceQuantity(changeQuantity);

        this.updatedAt = currentTime;
    }


    //remove item
    public void removeItem(UUID cartItemId, UUID productId, LocalDateTime currentTime) {
        if(this.cartStatus != CartStatus.ACTIVE) {
            throw new IllegalStateException("Cart is not in active state, unable to continue the process");
        }
        //check cart item and product is available
        boolean isCartItemAvailable = cartItems.stream()
                .anyMatch(item -> item.getCartItemId().equals(cartItemId) && item.getProductId().equals(productId));

        if(!isCartItemAvailable) {
            throw  new IllegalStateException("Item is not available in cart");
        }

        //remove cart item
        cartItems.removeIf(item -> item.getCartItemId().equals(cartItemId));

        this.updatedAt = currentTime;
    }

    //clear all items in cart
    public void clearCart(){
        if(this.cartStatus != CartStatus.ACTIVE) {
            throw new IllegalStateException("Cart is not in active state, unable to continue the process");
        }

        cartItems.clear();
        this.updatedAt = LocalDateTime.now();
    }

    //calculate cart total
    public void calculateCartItemTotal(LocalDateTime currentTime) {
        if(this.cartStatus != CartStatus.ACTIVE) {
            throw new IllegalStateException("Cart is not in active state, unable to continue the process");
        }

        //get items total by unitePrice * quantity
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            BigDecimal itemsTotal = cartItem.getUnitPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
            totalAmount = totalAmount.add(itemsTotal);
        };

        this.totalAmount = totalAmount;
        this.updatedAt = currentTime;
    }

    //checkout cart
    public void checkOut(){
        if(this.cartStatus != CartStatus.ACTIVE) {
            throw new IllegalStateException("Cart is not in active state, unable to continue the process");
        }

        boolean checkCartIsEmpty = cartItems.isEmpty();

        if(checkCartIsEmpty) {
            throw new IllegalStateException("Cart is empty");
        }

        this.cartStatus = CartStatus.CHECKED_OUT;
        this.updatedAt = LocalDateTime.now();

    }
}
