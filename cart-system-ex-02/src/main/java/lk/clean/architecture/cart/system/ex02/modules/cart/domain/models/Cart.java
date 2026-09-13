package lk.clean.architecture.cart.system.ex02.modules.cart.domain.models;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Cart {
    private final UUID cartId;
    private final UUID userId;
    private List<CartItem> cartItems;
    private double totalPrice;

    public Cart(UUID cartId, UUID userId, List<CartItem> cartItems, double totalPrice) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItems = cartItems;
        this.totalPrice = totalPrice;
    }

    /* __FACTORY_METHOD__ */

    public static Cart createNewCart(
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

    /* __DOMAIN_LOGIC__ */


    //add item
    public void addItem(UUID productId, String productName, double unitPrice, int requestedQuantity){
        //check incoming fields have value
        if(productId == null &&  productName == null && unitPrice <= 0 && requestedQuantity <= 0){
            throw new IllegalStateException("Required fields are cannot be empty");
        }

        //check product is available
        boolean checkCartItem = cartItems.stream().anyMatch(cartItem ->  cartItem.getProductId().equals(productId));

        //check availability
        if(checkCartItem){
            //get product related to id and name
            CartItem getItem = cartItems.stream()
                    .filter( cartItem -> cartItem.getProductId()
                            .equals(productId) && cartItem.getProductName().equals(productName))
                    .findFirst()
                    .orElseThrow(() ->  new IllegalArgumentException("Product not found"));

            //add to price with existing one
            getItem.updateQuantity(requestedQuantity);

        }else{
            //product not available create new cart item model
            CartItem newCartItem = CartItem.createNewCartItem(
                    productName,
                    unitPrice,
                    requestedQuantity
            );
            //add to list
            cartItems.add(newCartItem);
        }

    }

    //remove item
    public void removeItem(UUID productId){
        //check product id is empty
        if(productId == null){
            throw new IllegalStateException("Product id cannot be null");
        }

        //get product
        boolean checkItemExist = cartItems.stream().anyMatch(cartItem ->  cartItem.getProductId().equals(productId));

        //check product existence
        if(!checkItemExist){
            throw new IllegalStateException("Product not found");
        }

        //get specific product
        CartItem getItem = cartItems.stream().filter(cartItem -> cartItem.getProductId().
                equals(productId))
                .findFirst()
                .orElseThrow(() ->  new IllegalArgumentException("Product not found"));

        //remove it from list
        cartItems.remove(getItem);
    }
}

