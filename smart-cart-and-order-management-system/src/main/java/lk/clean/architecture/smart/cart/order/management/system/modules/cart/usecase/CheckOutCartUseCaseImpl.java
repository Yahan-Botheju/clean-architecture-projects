package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.enums.CartStatus;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.api.CheckCustomerApi;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.enums.CustomerStatus;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.api.ActiveProductCheckApi;
import lk.clean.architecture.smart.cart.order.management.system.shared_domain.customer_shared_api.CheckCustomerApiResult;

import java.util.UUID;

public class CheckOutCartUseCaseImpl {

    //inject dependencies
    private final CartRepository cartRepository;
    private final CheckCustomerApi checkCustomerApi;
    private final ActiveProductCheckApi activeProductCheckApi;

    public CheckOutCartUseCaseImpl(CartRepository cartRepository, CheckCustomerApi checkCustomerApi) {
        this.cartRepository = cartRepository;
        this.checkCustomerApi = checkCustomerApi;
    }

    public void checkOutCart(UUID                                                                ) {

        Cart cart = cartRepository.getCartByCartId(cartId)
                .orElseThrow(() -> new RuntimeException("cart not found"));

        boolean isCartActive = cart.getCartStatus() == CartStatus.ACTIVE;
        if(!isCartActive) {
            throw new IllegalStateException("cart not active state");
        }

        if(cart.getCartItems() != null && !cart.getCartItems().isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        CheckCustomerApiResult customerSnapshots = checkCustomerApi.checkCustomerByCustomerId(cart.getCustomerId());

        if(customerSnapshots.customerStatus() != CustomerStatus.ACTIVE){
            throw new IllegalStateException("customer not active state to continue the process");
        }

        cart.getCartItems().stream().filter(cart::)
    }
}
