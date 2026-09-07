package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule2Api;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.AirStatusOperationAssessmentRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.WeatherConditionOperationAssessmentRepository;

public class CheckFlightSafetyRule2ApiImpl implements CheckFlightSafetyRule2Api {

    //inject required dependencies
    private final WeatherConditionOperationAssessmentRepository weatherConditionOperationAssessmentRepository;
    private final AirStatusOperationAssessmentRepository airStatusOperationAssessmentRepository;

    public CheckFlightSafetyRule2ApiImpl(
            WeatherConditionOperationAssessmentRepository weatherConditionOperationAssessmentRepository,
            AirStatusOperationAssessmentRepository airStatusOperationAssessmentRepository
    ) {
        this.weatherConditionOperationAssessmentRepository = weatherConditionOperationAssessmentRepository;
        this.airStatusOperationAssessmentRepository = airStatusOperationAssessmentRepository;
    }


    //check flight safety rule 2
    @Override
    public boolean checkFlightSafetyRule2(String  pickUpLocation, String deliveryLocation) {


        //check pickup weather condition check
        OperationalAssessment pickUpWeather = weatherConditionOperationAssessmentRepository.getPickUpLocationWeatherCondition(pickUpLocation);
        OperationalAssessment pickUpAirStatus = airStatusOperationAssessmentRepository.getPickUpLocationAirStatus(pickUpLocation);

        //check drop off weather condition check
        OperationalAssessment deliveryWeather = weatherConditionOperationAssessmentRepository.getDropOffLocationWeatherCondition(deliveryLocation);
        OperationalAssessment deliveryAirStatus = airStatusOperationAssessmentRepository.getDropOffLocationAirStatus(deliveryLocation);

        //pickup domain model
        OperationalAssessment pickupOperation = OperationalAssessment.createOperationalAssessment(
                pickUpWeather.getWeatherCondition(),
                pickUpAirStatus.getAirSpaceStatus()
        );

        //delivery domain model
        OperationalAssessment deliveryOperation = OperationalAssessment.createOperationalAssessment(
                deliveryWeather.getWeatherCondition(),
                deliveryAirStatus.getAirSpaceStatus()
        );

        //call domain logic
        pickupOperation.checkFlightSafetyRule2();
        deliveryOperation.checkFlightSafetyRule2();

        return pickupOperation.isAllowed() && deliveryOperation.isAllowed();
    }
}
