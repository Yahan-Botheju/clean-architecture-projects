package lk.clean.architecture.cart.system.ex02.modules.cart.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.Cart;
import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.UpdateCartItemCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.UpdateCartItemResult;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;
import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.CatalogProductCheckResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

public class UpdateCartItemUseCaseImpl implements UpdateCartItemUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;
    private final CatalogProductCheckApi catalogProductCheckApi;

    public UpdateCartItemUseCaseImpl(
            CartRepository cartRepository,
            CatalogProductCheckApi catalogProductCheckApi
    ) {
        this.cartRepository = cartRepository;
        this.catalogProductCheckApi = catalogProductCheckApi;
    }

    //update cart item
    @Override
    public UpdateCartItemResult execute(UpdateCartItemCommand updateCartItemCommand) {

        //check for new request quantity has available stock
        CatalogProductCheckResult productSnapshots = catalogProductCheckApi.checkProductAvailability(
                updateCartItemCommand.productId(),
                updateCartItemCommand.newQuantity()
        );

        //get cart related to user id
        Cart cart = cartRepository.findByUserId(updateCartItemCommand.userId())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        //call domain method
        cart.updateItemQuantity(updateCartItemCommand.productId(), updateCartItemCommand.newQuantity());

        return new UpdateCartItemResult(
                updateCartItemCommand.productId(),
                productSnapshots.productName(),
                productSnapshots.unitPrice(),
                updateCartItemCommand.newQuantity()
        );
    }
}
