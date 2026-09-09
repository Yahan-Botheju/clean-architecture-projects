package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.AssignDroneUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CompleteMissionUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CreateDeliveryUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.StartMissionUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.AssignDroneWebMapper;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.CompleteMissionWebMapper;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.CreateDeliveryWebMapper;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.StartMissionWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    //inject required dependencies
    private final CreateDeliveryUseCase createDeliveryUseCase;
    private final CreateDeliveryWebMapper createDeliveryWebMapper;
    private final AssignDroneUseCase assignDroneUseCase;
    private final AssignDroneWebMapper assignDroneWebMapper;
    private final StartMissionUseCase  startMissionUseCase;
    private final StartMissionWebMapper startMissionWebMapper;
    private final CompleteMissionUseCase completeMissionUseCase;
    private final CompleteMissionWebMapper completeMissionWebMapper;

    public DeliveryController(
            CreateDeliveryUseCase createDeliveryUseCase,
            CreateDeliveryWebMapper createDeliveryWebMapper,
            AssignDroneUseCase assignDroneUseCase,
            AssignDroneWebMapper assignDroneWebMapper,
            StartMissionUseCase startMissionUseCase,
            StartMissionWebMapper startMissionWebMapper,
            CompleteMissionUseCase completeMissionUseCase,
            CompleteMissionWebMapper completeMissionWebMapper
    ) {
        this.createDeliveryUseCase = createDeliveryUseCase;
        this.createDeliveryWebMapper = createDeliveryWebMapper;
        this.assignDroneUseCase = assignDroneUseCase;
        this.assignDroneWebMapper = assignDroneWebMapper;
        this.startMissionUseCase = startMissionUseCase;
        this.startMissionWebMapper = startMissionWebMapper;
        this.completeMissionUseCase = completeMissionUseCase;
        this.completeMissionWebMapper = completeMissionWebMapper;
    }


    //create delivery
    @PostMapping
    public ResponseEntity<CreateDeliveryResponseDTO> createDelivery(
            @Valid @RequestBody CreateDeliveryRequestDTO createDeliveryRequestDTO
    ){
        CreateDeliveryCommand toCommand = createDeliveryWebMapper.toDeliveryCommand(createDeliveryRequestDTO);
        CreateDeliveryResult toUseCase = createDeliveryUseCase.createDelivery(toCommand);
        CreateDeliveryResponseDTO responseDTO = createDeliveryWebMapper.toDeliveryResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    //assign a drone
    @PostMapping("/assign-drone")
    public ResponseEntity<AssignDroneResponseDTO> assignDrone(
            @Valid @RequestBody AssignDroneRequestDTO assignDroneRequestDTO
    ){
        AssignDroneResult toUseCase = assignDroneUseCase.assignDrone(assignDroneRequestDTO.getDroneId());
        AssignDroneResponseDTO toResponseDTO = assignDroneWebMapper.toResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(toResponseDTO);
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
    @PostMapping("/complete")
    public ResponseEntity<CompleteMissionResponseDTO>  completeMission(
            @Valid @RequestBody CompleteMissionRequestDTO completeMissionRequestDTO
    ){
        CompleteMissionResult toUseCase = completeMissionUseCase.completeMission(completeMissionRequestDTO.getDeliveryId());
        CompleteMissionResponseDTO toResponse = completeMissionWebMapper.toResponse(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(toResponse);
    }
}
