package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.AssignDroneUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CreateDeliveryUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.AssignDroneRequestDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CreateDeliveryRequestDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CreateDeliveryResponseDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.AssignDroneWebMapper;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.CreateDeliveryWebMapper;
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

    public DeliveryController(
            CreateDeliveryUseCase createDeliveryUseCase,
            CreateDeliveryWebMapper createDeliveryWebMapper,
            AssignDroneUseCase assignDroneUseCase,
            AssignDroneWebMapper assignDroneWebMapper
    ) {
        this.createDeliveryUseCase = createDeliveryUseCase;
        this.createDeliveryWebMapper = createDeliveryWebMapper;
        this.assignDroneUseCase = assignDroneUseCase;
        this.assignDroneWebMapper = assignDroneWebMapper;
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
    @PostMapping("/{deliveryId}/assign-drone")
    public ResponseEntity<CreateDeliveryResponseDTO> assignDrone(
            @Valid @RequestBody AssignDroneRequestDTO assignDroneRequestDTO
    ){



    }
}
