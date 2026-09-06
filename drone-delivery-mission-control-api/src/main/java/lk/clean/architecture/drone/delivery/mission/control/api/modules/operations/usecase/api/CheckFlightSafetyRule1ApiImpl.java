package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1Api;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.AirStatusOperationAssessmentRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.WeatherConditionOperationAssessmentRepository;

public class CheckFlightSafetyRule1ApiImpl implements CheckFlightSafetyRule1Api {

    //inject required dependencies
    private final WeatherConditionOperationAssessmentRepository weatherConditionOperationAssessmentRepository;
    private final AirStatusOperationAssessmentRepository airStatusOperationAssessmentRepository;

    public CheckFlightSafetyRule1ApiImpl(
            WeatherConditionOperationAssessmentRepository weatherConditionOperationAssessmentRepository,
            AirStatusOperationAssessmentRepository airStatusOperationAssessmentRepository)
    {
        this.weatherConditionOperationAssessmentRepository = weatherConditionOperationAssessmentRepository;
        this.airStatusOperationAssessmentRepository = airStatusOperationAssessmentRepository;
    }


    //check flight safety rule 1
    @Override
    public boolean checkFlightSafetyRule1(String pickUpLocation, String deliveryLocation){

        //pick operation assessment
        OperationalAssessment pickupWeatherCondition =
                weatherConditionOperationAssessmentRepository.getPickUpLocationWeatherCondition(pickUpLocation);
        OperationalAssessment pickUpAirStatus =
                airStatusOperationAssessmentRepository.getPickUpLocationAirStatus(pickUpLocation);

        //delivery operation assessment
        OperationalAssessment deliveryWeatherCondition =
                weatherConditionOperationAssessmentRepository.getDropOffLocationWeatherCondition(deliveryLocation);

        OperationalAssessment deliveryAirStatus =
                airStatusOperationAssessmentRepository.getDropOffLocationAirStatus(deliveryLocation);

        //pickup domain model
        OperationalAssessment pickUpAssessmentOperation =  OperationalAssessment.createOperationalAssessment(
                pickupWeatherCondition.getWeatherCondition(),
                pickUpAirStatus.getAirSpaceStatus()
        );

        //delivery domain model
        OperationalAssessment deliveryAssessmentOperation =  OperationalAssessment.createOperationalAssessment(
                deliveryWeatherCondition.getWeatherCondition(),
                deliveryAirStatus.getAirSpaceStatus()
        );


        //check domain logic
        pickUpAssessmentOperation.checkFlightSafetyRule1();
        deliveryAssessmentOperation.checkFlightSafetyRule1();

        return pickUpAssessmentOperation.isAllowed() && deliveryAssessmentOperation.isAllowed();
    }
}
