package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule2;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;

public class CheckFlightSafetyRule2Impl implements CheckFlightSafetyRule2 {

    //check flight safety rule 2
    @Override
    public boolean checkFlightSafetyRule2(
            WeatherCondition weatherCondition,
            AirSpaceStatus airSpaceStatus
    ) {
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
