package lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.api;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.api.ActiveProductCheckApi;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.models.Product;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.repositories.ProductRepository;
import lk.clean.architecture.smart.cart.order.management.system.shared_domain.product_shared_api.ActiveProductCheckApiResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class ActiveProductCheckApiImpl implements ActiveProductCheckApi {

    //inject required dependencies
    private final ProductRepository productRepository;

    public ActiveProductCheckApiImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //check product availability
    @Override
    public ActiveProductCheckApiResult checkProductActive(UUID productId) {
        //check product
        Product getProduct = productRepository.getProductById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
        //check product availability
        getProduct.checkProductAvailability();

        return new ActiveProductCheckApiResult(
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
