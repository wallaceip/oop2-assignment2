package problemdomain;

public class Hatchback extends Vehicle {
    //hatchback specific attribute
    private String hatchType;

    public Hatchback(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String hatchType) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
        this.hatchType = hatchType;
    }

    //getter
    public String getHatchType() {
        return hatchType;
    }

    //override tostring to display hatchback info
    @Override
    public String toString() {
        String hatchDescription;

        switch (hatchType.toUpperCase()) {
            case "S":
                hatchDescription = "Standard Liftgate";
                break;
            case "T":
                hatchDescription = "Split liftgate";
                break;
            case "P":
                hatchDescription = "Power Liftgate";
                break;
            default:
                hatchDescription = "Unknown";
        }
        return  super.toString() + "\nHatch Type: " + hatchDescription;
    }




}
