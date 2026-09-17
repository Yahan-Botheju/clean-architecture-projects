package lk.clean.architecture.cart.system.ex02.modules.order.web.webMapper;

import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.GetOrderDetailsCommand;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.GetOrderDetailsResult;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.PlaceOrderCommand;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.PlaceOrderResult;
import lk.clean.architecture.cart.system.ex02.modules.order.web.DTOs.GetOrderDetailsRequestDTO;
import lk.clean.architecture.cart.system.ex02.modules.order.web.DTOs.GetOrderDetailsResponseDTO;
import lk.clean.architecture.cart.system.ex02.modules.order.web.DTOs.PlaceOrderRequestDTO;
import lk.clean.architecture.cart.system.ex02.modules.order.web.DTOs.PlaceOrderResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {

    /* __PLACE_ORDER__ */

    //requestDTO to usecase obj
    PlaceOrderCommand toPlaceOrderCommand(PlaceOrderRequestDTO  placeOrderRequestDTO);

    //domain model to responseDTO
    PlaceOrderResponseDTO toPlaceOrderResponseDTO(PlaceOrderResult placeOrderResult);


    /* __GET_ORDER_DETAILS__ */

    //requestDTO to usecase obj
    GetOrderDetailsCommand toGetOrderDetailsCommand(GetOrderDetailsRequestDTO getOrderDetailsRequestDTO);

    //domain model to responseDTO
    GetOrderDetailsResponseDTO toGetOrderDetailsResponseDTO(GetOrderDetailsResult getOrderDetailsResult);

}
