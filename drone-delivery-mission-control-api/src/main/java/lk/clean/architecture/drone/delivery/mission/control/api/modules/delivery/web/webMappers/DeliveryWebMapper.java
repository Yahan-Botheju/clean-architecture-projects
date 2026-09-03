package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.DeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.DeliveryRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryWebMapper {

    //dto to command
    DeliveryCommand toDeliveryCommand(DeliveryRequestDTO deliveryRequestDTO);
}
