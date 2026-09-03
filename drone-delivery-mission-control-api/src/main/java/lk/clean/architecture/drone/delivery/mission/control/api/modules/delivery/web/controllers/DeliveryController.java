package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.controllers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.DeliveryUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers.DeliveryWebMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    //inject required dependencies
    private final DeliveryUseCase  deliveryUseCase;
    private final DeliveryWebMapper deliveryWebMapper;

    public DeliveryController(
            DeliveryUseCase deliveryUseCase,
            DeliveryWebMapper deliveryWebMapper
    ) {
        this.deliveryUseCase = deliveryUseCase;
        this.deliveryWebMapper = deliveryWebMapper;
    }
}
