package lk.clean.architecture.ecommerce.order.processing.module.web.webMappers;

import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;
import lk.clean.architecture.ecommerce.order.processing.module.web.DTOs.OrderResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {
    //domain model to responseDTO
    OrderResponseDTO toResponseDTO(Order order);
}
