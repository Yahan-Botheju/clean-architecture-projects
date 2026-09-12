package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.api_impl;

import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogStockDeductApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class CatalogStockDeductApiImpl implements CatalogStockDeductApi {

    //inject required dependencies
    private final ProductRepository productRepository;

    public CatalogStockDeductApiImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //deduct quantity
    @Override
    public void deductStock(UUID productId, int quantity) {
        //check quantity is not empty
        if(quantity <= 0){
            throw new IllegalStateException("Quantity cannot be empty");
        }

        Product product = productRepository.productFindById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));

        //use domain logic
        product.deductStock(quantity);
    }
}
