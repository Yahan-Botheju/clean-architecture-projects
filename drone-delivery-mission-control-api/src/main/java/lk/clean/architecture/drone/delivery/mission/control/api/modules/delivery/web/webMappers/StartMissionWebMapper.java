package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.StartMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.StartMissionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StartMissionWebMapper {

    //domain model to response dto
    StartMissionResponseDTO toResponse(StartMissionResult startMissionResult);
}
