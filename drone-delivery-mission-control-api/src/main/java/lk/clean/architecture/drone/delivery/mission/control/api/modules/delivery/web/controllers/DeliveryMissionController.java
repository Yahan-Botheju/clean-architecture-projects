package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CompleteMissionUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.StartMissionUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.CompleteMissionWebMapper;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.StartMissionWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/deliveries/missions")
public class DeliveryMissionController {

    //inject required dependencies
    private final StartMissionUseCase  startMissionUseCase;
    private final StartMissionWebMapper startMissionWebMapper;
    private final CompleteMissionUseCase completeMissionUseCase;
    private final CompleteMissionWebMapper completeMissionWebMapper;

    public DeliveryMissionController(
            StartMissionUseCase startMissionUseCase,
            StartMissionWebMapper startMissionWebMapper,
            CompleteMissionUseCase completeMissionUseCase,
            CompleteMissionWebMapper completeMissionWebMapper
    ) {
        this.startMissionUseCase = startMissionUseCase;
        this.startMissionWebMapper = startMissionWebMapper;
        this.completeMissionUseCase = completeMissionUseCase;
        this.completeMissionWebMapper = completeMissionWebMapper;
    }


    //start mission
    @PostMapping("/start-mission")
    public ResponseEntity<StartMissionResponseDTO> startMission(
            @Valid @RequestBody StartMissionRequestDTO startMissionRequestDTO
    ){
        StartMissionResult toUseCase = startMissionUseCase.startMission(startMissionRequestDTO.getDeliveryId());
        StartMissionResponseDTO toResponse = startMissionWebMapper.toResponse(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(toResponse);
    }

    //complete mission
    @PostMapping("/complete-mission")
    public ResponseEntity<CompleteMissionResponseDTO>  completeMission(
            @Valid @RequestBody CompleteMissionRequestDTO completeMissionRequestDTO
    ){
        CompleteMissionResult toUseCase = completeMissionUseCase.completeMission(completeMissionRequestDTO.getDeliveryId());
        CompleteMissionResponseDTO toResponse = completeMissionWebMapper.toResponse(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(toResponse);
    }
}
