package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.AssignDroneUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CancelDeliveryUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CreateDeliveryUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.DeliveryManagementWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/delivery-management")
public class DeliveryManagementController {

    //inject required dependencies
    private final CreateDeliveryUseCase createDeliveryUseCase;
    private final AssignDroneUseCase assignDroneUseCase;
    private final CancelDeliveryUseCase cancelDeliveryUseCase;
    private final DeliveryManagementWebMapper deliveryManagementWebMapper;


    public DeliveryManagementController(
            CreateDeliveryUseCase createDeliveryUseCase,
            DeliveryManagementWebMapper deliveryManagementWebMapper,
            CancelDeliveryUseCase cancelDeliveryUseCase,
            AssignDroneUseCase assignDroneUseCase
    ) {
        this.createDeliveryUseCase = createDeliveryUseCase;
        this.deliveryManagementWebMapper = deliveryManagementWebMapper;
        this.cancelDeliveryUseCase = cancelDeliveryUseCase;
        this.assignDroneUseCase = assignDroneUseCase;
    }

    //create delivery
    @PostMapping
    public ResponseEntity<CreateDeliveryResponseDTO> createDelivery(
            @Valid @RequestBody CreateDeliveryRequestDTO createDeliveryRequestDTO
    ){
        CreateDeliveryCommand toCommand = deliveryManagementWebMapper.toDeliveryCommand(createDeliveryRequestDTO);
        CreateDeliveryResult toUseCase = createDeliveryUseCase.createDelivery(toCommand);
        CreateDeliveryResponseDTO responseDTO = deliveryManagementWebMapper.toDeliveryResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    //assign a drone
    @PostMapping("/assign-drone")
    public ResponseEntity<AssignDroneResponseDTO> assignDrone(
            @Valid @RequestBody AssignDroneRequestDTO assignDroneRequestDTO
    ){
        AssignDroneResult toUseCase = assignDroneUseCase.assignDrone(assignDroneRequestDTO.getDroneId());
        AssignDroneResponseDTO toResponseDTO = deliveryManagementWebMapper.toAssignResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(toResponseDTO);
    }


}
