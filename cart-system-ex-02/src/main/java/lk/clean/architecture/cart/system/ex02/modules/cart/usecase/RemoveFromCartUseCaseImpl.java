package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.Cart;
import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.RemoveFromCartCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.RemoveFromCartResult;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.GetProductDetailsApi;
import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.GetProductDetailsResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

public class RemoveFromCartUseCaseImpl implements RemoveFromCartUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;
    private final GetProductDetailsApi getProductDetailsApi;

    public RemoveFromCartUseCaseImpl(
            CartRepository cartRepository,
            GetProductDetailsApi getProductDetailsApi
    ) {
        this.cartRepository = cartRepository;
        this.getProductDetailsApi = getProductDetailsApi;
    }

    //remove from cart
    @Override
    public RemoveFromCartResult removeFromCart(RemoveFromCartCommand removeFromCartCommand) {

        //check incoming fields are empty
        if (removeFromCartCommand.userId() == null || removeFromCartCommand.productId() == null) {
            throw new ResourceNotFoundException("Required fields are empty");
        }
        //get product
        GetProductDetailsResult productSnapshots = getProductDetailsApi.getProductDetails(removeFromCartCommand.productId());

        //get cart related to user
        Optional<Cart> getCart = cartRepository.findByUserId(removeFromCartCommand.userId());
        Cart cart = getCart.orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        //call domain model for remove item from cart
        cart.removeItem(removeFromCartCommand.productId());

        cartRepository.save(cart);

        return new RemoveFromCartResult(
                productSnapshots.productId(),
                productSnapshots.productName(),
                productSnapshots.unitPrice(),
                cart.getCartId(),
                cart.getUserId()
        );
    }
}
