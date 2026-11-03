package problemdomain;

public class Hybrid extends Vehicle {
    //hybrid class specific attributes
    private String powertrain;
    private int electricRange;

    public Hybrid(long carID, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String powertrain, int electricRange) {
        super(carID, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
        this.powertrain = powertrain;
        this.electricRange = electricRange;
    }

    //getters
    public String getPowertrain() {
        return powertrain;
    }
    public int getElectricRange() {
        return electricRange;
    }

    //override tostring
    @Override
    public String toString() {

        String powertrainDescription;

        switch (powertrain.toUpperCase()) {
            case "E":
                powertrainDescription = "Series Hybrid";
                break;
            case "A":
                powertrainDescription = "Parallel Hybrid";
                break;
            case "PHEV":
                powertrainDescription = "Plug-in Hybrid";
                break;
            default:
                powertrainDescription = "Unknown";
        }
     return super.toString()+"\nPowertrain: " + powertrainDescription + "\nElectric Range: " + electricRange;
    }
}
