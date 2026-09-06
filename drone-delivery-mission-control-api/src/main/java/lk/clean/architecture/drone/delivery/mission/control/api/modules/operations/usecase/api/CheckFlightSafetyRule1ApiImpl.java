package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1Api;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.OperationAssementRepository;

public class CheckFlightSafetyRule1ApiImpl implements CheckFlightSafetyRule1Api {

    //inject required dependencies
    private final OperationAssementRepository operationAssementRepository;

    public CheckFlightSafetyRule1ApiImpl(OperationAssementRepository operationAssementRepository) {
        this.operationAssementRepository = operationAssementRepository;
    }


    //check flight safety rule 1
    @Override
    public boolean checkFlightSafetyRule1(
            WeatherCondition weatherCondition,
            AirSpaceStatus airSpaceStatus
    ){
        //create model using factor method
        OperationalAssessment newOperation =  OperationalAssessment.createOperationalAssessment(
                weatherCondition,
                airSpaceStatus
        );


        //check domain logic
        newOperation.checkFlightSafetyRule1();

        return newOperation.isAllowed();
    }
}
