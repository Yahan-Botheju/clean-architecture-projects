package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class Drone {

    private UUID droneId;
    private String serialNumber;
    private DroneStatus droneStatus;
    private double maxPayloadingKg;
    private double batteryPercentage;

    public Drone(UUID droneId, String serialNumber, DroneStatus droneStatus, double maxPayloadingKg,double batteryPercentage) {
        this.droneId = droneId;
        this.serialNumber = serialNumber;
        this.droneStatus = droneStatus;
        this.maxPayloadingKg = maxPayloadingKg;
        this.batteryPercentage = batteryPercentage;
    }

    public UUID getDroneId() { return droneId; }
    public String getSerialNumber() { return serialNumber; }
    public DroneStatus getDroneStatus() { return droneStatus; }
    public double getMaxPayloadingKg() { return maxPayloadingKg; }
    public double getBatteryPercentage() { return batteryPercentage; }



    /* __DOMAIN_LOGIC__ */


    //check drone for package delivery
    public void checkDrone(double packageWeight) {
        //check drone availability
        if(this.droneStatus != DroneStatus.AVAILABLE){
            throw new ResourceNotFoundException("DroneStatus not available");
        }
        //check max payload
        if(this.maxPayloadingKg <= packageWeight){
            throw new IllegalStateException("Pay loading KG exceeds");
        }

        //check battery percentage
        double requiredBatteryPercentage = 20 + (packageWeight * 5);

        if(this.batteryPercentage < requiredBatteryPercentage){
            throw new IllegalStateException("Battery percentage exceeds");
        }
    }
}
