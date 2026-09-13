package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records.CreateProductCommand;
import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records.CreateProductResult;

import java.security.InvalidParameterException;

public class CreateProductUseCaseImpl implements CreateProductUseCase{

    //inject required dependencies
    private final ProductRepository productRepository;

    public CreateProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //create new product
    @Override
    public CreateProductResult execute(CreateProductCommand createProductCommand) {
        //check inputs are empty
        if(
                createProductCommand.productName().isEmpty() &&
                        createProductCommand.unitPrice() <= 0 &&
                        createProductCommand.initialStock() <= 0
        ){
            throw new InvalidParameterException("Product name and unit price must be filled");
        }


        //create product model
        Product newProductModel = Product.createNewProduct(
                createProductCommand.productName(),
                createProductCommand.unitPrice(),
                createProductCommand.initialStock()
        );

        productRepository.saveProduct(newProductModel);

        return new CreateProductResult(
                newProductModel.getProductId(),
                newProductModel.getProductName(),
                newProductModel.getUnitPrice(),
                newProductModel.getStockQuantity(),
                newProductModel.getProductStatus()
        );
    }
}
