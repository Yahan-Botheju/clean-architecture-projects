package lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.configs;

import lk.clean.architecture.cart.system.ex02.modules.cart.api.CartQueryApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogStockDeductApi;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.repository.OrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.GetOrderDetailsUseCase;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.GetOrderDetailsUseCaseImpl;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.PlaceOrderUseCase;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.PlaceOrderUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //place order usecase impl
    @Bean
    public PlaceOrderUseCase placeOrderUseCase(
            OrderRepository orderRepository,
            CartQueryApi cartQueryApi,
            CatalogStockDeductApi catalogStockDeductApi
    ) {
        return new PlaceOrderUseCaseImpl(orderRepository, cartQueryApi, catalogStockDeductApi);
    }

    //get order details usecase impl
    @Bean
    public GetOrderDetailsUseCase getOrderDetailsUseCase(
            OrderRepository orderRepository
    ){
        return new GetOrderDetailsUseCaseImpl(orderRepository);
    }
}
