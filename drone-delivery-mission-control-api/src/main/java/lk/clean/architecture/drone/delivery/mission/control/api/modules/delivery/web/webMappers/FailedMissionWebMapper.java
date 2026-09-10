package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.FailedMissionRequestDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.FailedMissionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FailedMissionWebMapper {

    //requestDTO to usecase object
    FailedMissionCommand toFailedMissionCommand(FailedMissionRequestDTO failedMissionRequestDTO);

    //domain model to responseDTO
    FailedMissionResponseDTO toFailedMissionResponseDto(FailedMissionResult failedMissionResult);
}
