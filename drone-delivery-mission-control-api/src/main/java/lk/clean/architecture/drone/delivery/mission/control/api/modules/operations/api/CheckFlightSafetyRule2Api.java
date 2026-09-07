package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api;

public interface CheckFlightSafetyRule2Api {

    //check flight safety rule 2
    boolean checkFlightSafetyRule2(String pickUpLocation, String deliveryLocation);
}
