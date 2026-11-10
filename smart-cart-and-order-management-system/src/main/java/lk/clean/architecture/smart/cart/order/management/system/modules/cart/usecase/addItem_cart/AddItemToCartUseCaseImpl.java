package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.addItem_cart;


import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records.AddItemToCartResult;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.api.ActiveProductCheckApi;
import lk.clean.architecture.smart.cart.order.management.system.shared_domain.product_shared_api.ActiveProductCheckApiResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddItemToCartUseCaseImpl implements AddItemToCartUseCase {

    //inject dependencies
    private final CartRepository cartRepository;
    private final ActiveProductCheckApi activeProductCheckApi;


    public AddItemToCartUseCaseImpl(
            CartRepository cartRepository,
            ActiveProductCheckApi activeProductCheckApi
    ) {
        this.cartRepository = cartRepository;
        this.activeProductCheckApi = activeProductCheckApi;
    }

    //add item to cart
    @Override
    public AddItemToCartResult addItemToCart(UUID cartId, UUID productId, int requestedQuantity){
        //check cart existence
        Cart getCart = cartRepository.getCartByCartId(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        //check cart belongs to customer
        cartRepository.getActiveCartByCustomerId(getCart.getCustomerId());

        //check product and get snapshots
        ActiveProductCheckApiResult productSnapshot = activeProductCheckApi.checkProductActive(productId);

        LocalDateTime currentTime = LocalDateTime.now();

        //call cart add item method
        getCart.addItem(
                productSnapshot.productId(),
                requestedQuantity,
                productSnapshot.productPrice(),
                currentTime
        );

        cartRepository.saveCart(getCart);

        return new  AddItemToCartResult(
                getCart.getCartId(),
                getCart.getCustomerId(),
                getCart.getCartStatus(),
                getCart.getTotalAmount(),
                getCart.getCreatedAt(),
                getCart.getUpdatedAt(),
                getCart.getCartItems()
        );
    }
}
