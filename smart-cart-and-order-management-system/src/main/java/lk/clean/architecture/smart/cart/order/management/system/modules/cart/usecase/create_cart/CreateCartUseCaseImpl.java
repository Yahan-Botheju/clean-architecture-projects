package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.create_cart;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.enums.CartStatus;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records.CreateCartResult;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.api.CheckCustomerApi;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class CreateCartUseCaseImpl implements CreateCartUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;
    private final CheckCustomerApi checkCustomerApi;

    public CreateCartUseCaseImpl(CartRepository cartRepository, CheckCustomerApi checkCustomerApi) {
        this.cartRepository = cartRepository;
        this.checkCustomerApi = checkCustomerApi;
    }

    //create new cart
    @Override
    public CreateCartResult createCart(UUID customerId){

        //check customer exists and ACTIVE
        checkCustomerApi.checkCustomerByCustomerId(customerId);

        //check active carts
        Optional<Cart> cart = cartRepository.getActiveCartByCustomerId(customerId);

        //check customer has active cart
        boolean isCartActive = cart.stream().anyMatch(activeCart -> activeCart.getCartStatus().equals(CartStatus.ACTIVE));
        if(isCartActive) {
            throw new IllegalStateException("Customer already has active cart");
        }

        //create new cart
        LocalDateTime createdAt = LocalDateTime.now();
        Cart newCart = Cart.createNewCart(
                customerId,
                null,
                createdAt,
                null
        );

        cartRepository.saveCart(newCart);

        return new CreateCartResult(
                newCart.getCartId(),
                newCart.getCustomerId(),
                newCart.getCartStatus(),
                newCart.getTotalAmount(),
                newCart.getCreatedAt(),
                newCart.getUpdatedAt()
        );
    }
}
