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





        //create domain model using factory method
        OperationalAssessment newOperation = OperationalAssessment.createOperationalAssessment(
                weatherCondition,
                airSpaceStatus
        );
        //call domain logic
        newOperation.checkFlightSafetyRule2();

        return newOperation.isAllowed();
    }
}
