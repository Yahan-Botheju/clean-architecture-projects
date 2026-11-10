package lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.enums.ProductStatus;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.models.Product;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.repositories.ProductRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.CreateProductCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.CreateProductResult;

import java.time.LocalDateTime;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    //inject required dependencies
    private final ProductRepository productRepository;

    public CreateProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //create product
    @Override
    public CreateProductResult createProduct(CreateProductCommand createProductCommand) {

        //check product existence
        boolean isAlreadyExists = productRepository.checkProductBySku(createProductCommand.sku());

        if(isAlreadyExists){
            throw new IllegalStateException("Product already exists");
        }

        /* __CREATE_NEW_PRODUCT__ */

        LocalDateTime currentDateTime = LocalDateTime.now();

        Product newProduct = Product.createNewProduct(
                createProductCommand.sku(),
                createProductCommand.productName(),
                createProductCommand.productDescription(),
                createProductCommand.productPrice(),
                ProductStatus.ACTIVE,
                currentDateTime
        );

        return new CreateProductResult(
                newProduct.getProductId(),
                newProduct.getSku(),
                newProduct.getProductName(),
                newProduct.getProductDescription(),
                newProduct.getProductPrice(),
                newProduct.getProductStatus(),
                newProduct.getCreatedAt()
        );
    }
}
