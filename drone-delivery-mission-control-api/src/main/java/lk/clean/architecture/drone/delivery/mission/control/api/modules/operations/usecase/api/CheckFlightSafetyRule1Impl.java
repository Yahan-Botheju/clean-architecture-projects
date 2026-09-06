package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;

public class CheckFlightSafetyRule1Impl implements CheckFlightSafetyRule1 {

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
