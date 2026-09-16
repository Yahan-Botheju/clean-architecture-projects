package lk.clean.architecture.cart.system.ex02.modules.order.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.api.CartQueryApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogStockDeductApi;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.repository.OrderRepository;

public class PlaceOrderUseCaseImpl implements PlaceOrderUseCase {

    //inject required dependencies
    private final OrderRepository orderRepository;
    private final CartQueryApi cartQueryApi;
    private final CatalogStockDeductApi catalogStockDeductApi;

    public PlaceOrderUseCaseImpl(
            OrderRepository orderRepository,
            CartQueryApi cartQueryApi,
            CatalogStockDeductApi catalogStockDeductApi
    ) {
        this.orderRepository = orderRepository;
        this.cartQueryApi = cartQueryApi;
        this.catalogStockDeductApi = catalogStockDeductApi;
    }
}
