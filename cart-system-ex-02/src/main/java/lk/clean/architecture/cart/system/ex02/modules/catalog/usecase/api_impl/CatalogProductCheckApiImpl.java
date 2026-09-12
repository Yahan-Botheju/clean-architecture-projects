package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.api_impl;

import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.CatalogProductCheckResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class CatalogProductCheckApiImpl implements CatalogProductCheckApi {

    //inject required dependencies
    private final ProductRepository productRepository;

    public CatalogProductCheckApiImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //check product availability
    @Override
    public CatalogProductCheckResult checkProductAvailability(UUID productId, int requestedQuantity) {
        //check req.quantity is empty
        if(requestedQuantity <= 0){
            throw new IllegalStateException("Requested quantity cannot be empty");
        }

        Product getProduct = productRepository.productFindById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));

        //use domain logic
        getProduct.enoughStockAvailable(requestedQuantity);

        productRepository.saveProduct(getProduct);

        return new CatalogProductCheckResult(
                getProduct.getProductId(),
                getProduct.getProductName(),
                getProduct.getUnitPrice(),
                getProduct.getStockQuantity(),
                getProduct.getProductStatus()
        );
    }
}
