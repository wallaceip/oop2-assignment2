package problemdomain;

public class Sedan extends Vehicle {
    //sedan specific attribute
    private String trunkSize;

    public Sedan(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year,
                 String drivetrain, int price, int quantity, String trunkSize) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
        this.trunkSize = trunkSize;
    }

    //getter
    public String getTrunkSize() {
        return trunkSize;
    }

    //override tString to display sedan info
    @Override
    public String toString() {

        String trunkDescription;

        switch (trunkSize.toUpperCase()){
            case "L":
                trunkDescription = "Large/spacious Trunk";
                break;
            case "M":
                trunkDescription = "Moderate Trunk";
                break;
            case "S":
                trunkDescription = "Small Trunk";
                break;
            default:
                trunkDescription = "Unknown";
        }
        return super.toString() +"\nTrunkSize: " + trunkDescription;
    }
}
