package practice;

public class Vehicel {
     int vehicleId;
     String vehicleName;
     String vehicleType;
     String ownerName;


     public Vehicel(int vehicleId, String vehicleName, String vehicleType, String ownerName) {
         this.vehicleId = vehicleId;
         this.vehicleName = vehicleName;
         this.vehicleType = vehicleType;
         ownerInfo(ownerName);
     }

     public void ownerInfo(String ownerName){
         if(ownerName.isBlank()){
             return;
         }
         this.ownerName = ownerName;
     }


     void printVehicleInfo(){
         if ( ownerName == null ) {
             System.out.println("Owner name cannot be empty");
             return;
         }
         System.out.println("Vehicle Id: " + vehicleId);
         System.out.println("Vehicle Name: " + vehicleName);
         System.out.println("Vehicle Type: " + vehicleType);
         System.out.println("Owner Name: " + ownerName);
     }
}
