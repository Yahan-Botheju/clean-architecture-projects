package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;

public interface WeatherConditionOperationAssessmentRepository {

    //get pickup location weather condition
    OperationalAssessment getPickUpLocationWeatherCondition(String pickUpLocation);

    //get pickup location airspace status
    OperationalAssessment getDropOffLocationWeatherCondition(String deliveryLocation);
}
