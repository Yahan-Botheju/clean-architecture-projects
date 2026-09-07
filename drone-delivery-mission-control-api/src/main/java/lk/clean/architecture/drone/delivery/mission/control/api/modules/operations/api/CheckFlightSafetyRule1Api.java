package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api;

public interface CheckFlightSafetyRule1Api {

    //check flight safety rule 1
    public boolean checkFlightSafetyRule1(String pickUpLocation, String deliveryLocation);
}
