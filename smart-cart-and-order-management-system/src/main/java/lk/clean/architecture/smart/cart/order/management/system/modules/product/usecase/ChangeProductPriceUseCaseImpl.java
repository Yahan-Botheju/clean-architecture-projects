package lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.models.Product;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.repositories.ProductRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.ChangeProductPriceCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.ChangeProductPriceResult;

import java.math.BigDecimal;

public class ChangeProductPriceUseCaseImpl implements ChangeProductPriceUseCase {

    //inject required dependencies
    private final ProductRepository productRepository;

    public ChangeProductPriceUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //change product price
    @Override
    public ChangeProductPriceResult changeProductPrice(
            ChangeProductPriceCommand changeProductPriceCommand
    ) {

        //check price is empty
        if(changeProductPriceCommand.productPrice().compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException("price must be greater than zero");
        }

        Product getProduct = productRepository.getProductById(changeProductPriceCommand.productId())
                .orElseThrow(() -> new IllegalArgumentException("product not found"));

        //call domain logic
        getProduct.changeProductPrice(changeProductPriceCommand.productPrice());

        productRepository.saveProduct(getProduct);


        return new ChangeProductPriceResult(
                getProduct.getProductId(),
                getProduct.getSku(),
                getProduct.getProductName(),
                getProduct.getProductDescription(),
                getProduct.getProductPrice(),
                getProduct.getProductStatus(),
                getProduct.getCreatedAt()
        );
    }
}
