package problemdomain;

public class PickupTruck extends Vehicle {
    //truck specific attributes
    private String cargoBedType;
    private int cargoCapacity;

    public PickupTruck(long carID, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String cargoBedType, int cargoCapacity) {
        super(carID, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
        this.cargoBedType = cargoBedType;
        this.cargoCapacity = cargoCapacity;
    }

    //getters
    public String getCargoBedType() {
        return cargoBedType;
    }
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    //Override toString and switch case for cargo bed type
    @Override
    public String toString(){
        String cargoBedDescription;
        switch (cargoBedType.toUpperCase()) {
            case "SB":
                cargoBedDescription = "Short Bed";
                break;
            case "EB":
                cargoBedDescription = "Extended Bed";
                break;
            case "DB":
                cargoBedDescription = "Dump Bed";
                break;
            default:
                cargoBedDescription = "Unknown";
        }
        return super.toString() + "\nCargo Capacity: " + cargoCapacity + "\nCargo Bed Type: " + cargoBedDescription;
    }
}
