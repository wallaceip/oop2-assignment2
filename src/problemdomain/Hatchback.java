package problemdomain;

public class Hatchback extends Vehicle {

    private char hatchType;

    public Hatchback(Long carID, String vehicleType, String vehicleSubtype, int speed, double fuel, int seats,
                     int year, String driveTrain, int price, int quantity, char hatchType) {

        super(carID, vehicleType, vehicleSubtype, speed, fuel, seats, year, driveTrain, price, quantity);

        this.hatchType = hatchType;

    }

    //getter

    public char getHatchType() {
        return hatchType;
    }

    //setter

    public void setHatchType(char hatchType) {
        this.hatchType = hatchType;
    }

    @Override
    public String formatForFile() {
        return getCarID() + ";" + getVehicleType() + ";" + getVehicleSubtype() + ";" + getSpeed() + ";" + getFuel() + ";" + getSeats() + ";" + getYear() + ";"
                + getDriveTrain() + ";" + getPrice() + ";" + getQuantity() + ";" + getHatchType();
    }

    @Override
    public String toString() {

        String hatch = "";
        if (getHatchType() == 'S') {
            hatch = "Standard Liftgate";
        } else if (getHatchType() == 'T')
            hatch = "Split Liftgate";
        else if (getHatchType() == 'P') {
            hatch = "Power Liftgate";
        }

        return
                "\n" +
                        "Car ID: \t\t" + getCarID() + "\n" +
                        "Vehicle Type:" + getVehicleType() + "\n" +
                        "Subtype: \t" + getVehicleSubtype() + "\n" +
                        "Speed:\t" + getSpeed() + "\n" +
                        "Fuel: \t" + getFuel() + "\n" +
                        "Number of seats: \t" + getSeats() + "\n" +
                        "Year: \t" + getYear() + "\n" +
                        "DriveTrain: \t" + getDriveTrain() + "\n" +
                        "Price: \t" + getPrice() + "\n" +
                        "Available: \t" + getQuantity() + "\n" +
                        "Hatch Type: " + hatch;
    }
}
