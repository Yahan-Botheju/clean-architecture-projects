package lk.clean.architecture.smart.cart.order.management.system.modules.product.web.webMapper;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.ChangeProductPriceCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.ChangeProductPriceResult;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs.ChangeProductPriceRequestDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs.ChangeProductPriceResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChangeProductPriceWebMapper {

    //requestDTO to usecase Obj
    ChangeProductPriceCommand toChangeProductPriceCommand(ChangeProductPriceRequestDTO changePriceRequestDTO);

    //domain model to responseDTO
    ChangeProductPriceResponseDTO toChangePriceResponseDTO(ChangeProductPriceResult changeProductPriceResult);
}
