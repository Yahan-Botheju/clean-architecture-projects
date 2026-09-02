package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;

public record OperationalAssessment(
        WeatherCondition weatherCondition,
        AirSpaceStatus airSpaceStatus,
        boolean allowed,
        String reason
) {

    //check weather and air is okay to fly the drone
    public void checkFlightSafety(){
        if(this.weatherCondition == WeatherCondition.STORM
                && (this.airSpaceStatus == AirSpaceStatus.CLOSED
                || this.airSpaceStatus == AirSpaceStatus.RESTRICTED)
        ){
            throw new IllegalArgumentException("Cannot continue mission under these condition");
        }
    }
}
