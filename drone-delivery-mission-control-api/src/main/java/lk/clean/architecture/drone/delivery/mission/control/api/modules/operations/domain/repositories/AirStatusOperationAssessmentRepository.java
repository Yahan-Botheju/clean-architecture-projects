package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;

public interface AirStatusOperationAssessmentRepository {

    //pickup location air status
    OperationalAssessment getPickUpLocationAirStatus(String pickUpLocation);

    //delivery location air status
    OperationalAssessment getDropOffLocationAirStatus(String deliveryLocation);
}
