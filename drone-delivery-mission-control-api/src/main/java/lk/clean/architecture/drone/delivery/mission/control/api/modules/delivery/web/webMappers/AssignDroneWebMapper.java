package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.AssignDroneResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.AssignDroneResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring" )
public interface AssignDroneWebMapper {

    //domain model to responseDTO
    AssignDroneResponseDTO toResponseDTO(AssignDroneResult assignDroneResult);

}
