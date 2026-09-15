package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.api_impl;

import lk.clean.architecture.cart.system.ex02.modules.catalog.api.GetProductDetailsApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.GetProductDetailsResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class GetProductDetailsApiImpl implements GetProductDetailsApi {

    //inject required dependencies
    private final ProductRepository productRepository;

    public GetProductDetailsApiImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //get product details by id
    @Override
    public GetProductDetailsResult getProductDetails(UUID productId) {

        Product getProduct = productRepository.productFindById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));


        return new GetProductDetailsResult(
                getProduct.getProductId(),
                getProduct.getProductName(),
                getProduct.getUnitPrice(),
                getProduct.getStockQuantity(),
                getProduct.getProductStatus()
        );
    }
}
