package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.DeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.DeliveryResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.DeliveryRequestDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.DeliveryResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryWebMapper {

    //dto to command
    DeliveryCommand toDeliveryCommand(DeliveryRequestDTO deliveryRequestDTO);

    //domain model to response
    DeliveryResponseDTO toDeliveryResponseDTO(DeliveryResult deliveryResult);
}
