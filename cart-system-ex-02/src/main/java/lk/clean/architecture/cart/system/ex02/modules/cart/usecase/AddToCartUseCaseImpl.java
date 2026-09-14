package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.Cart;
import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartResult;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;
import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.CatalogProductCheckResult;

import java.util.ArrayList;
import java.util.Optional;

public class AddToCartUseCaseImpl implements AddToCartUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;
    private final CatalogProductCheckApi catalogProductCheckApi;

    public AddToCartUseCaseImpl(
            CartRepository cartRepository,
            CatalogProductCheckApi catalogProductCheckApi
    ) {
        this.cartRepository = cartRepository;
        this.catalogProductCheckApi = catalogProductCheckApi;
    }

    //add to item to cart
    @Override
    public AddToCartResult execute(AddToCartCommand addToCartCommand) {

        //validate incoming quantity
        if( addToCartCommand.userId() == null || addToCartCommand.productId() == null ||addToCartCommand.quantity() <= 0){
            throw new IllegalArgumentException("Required parameters missing, try again");
        }

        //check product availability and  has enough stock
        CatalogProductCheckResult productSnapshot = catalogProductCheckApi.checkProductAvailability(addToCartCommand.productId(), addToCartCommand.quantity());

        //get user cart
        Optional<Cart> getCart = cartRepository.findByUserId(addToCartCommand.userId());

        //if cart not available create new one or use existence one
        Cart cart = getCart.orElseGet(() -> Cart.createNewCart(
                addToCartCommand.userId(),
                new ArrayList<>(),
                0.0
        ));

        //add values to cart by calling domain logic
        cart.addItem(
                addToCartCommand.productId(),
                productSnapshot.productName(),
                productSnapshot.unitPrice(),
                addToCartCommand.quantity()
        );

        //save in db
        cartRepository.save(cart);

        return new AddToCartResult(
                cart.getCartId(),
                cart.getUserId(),
                cart.getCartItems(),
                cart.getTotalPrice()
        );
    }
}
