package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.webMappers;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.DTOs.OrderResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {

    //domain model to response
    OrderResponseDTO toResponseDTO(Order order);
}
