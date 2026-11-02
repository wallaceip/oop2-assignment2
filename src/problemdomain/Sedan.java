package problemdomain;


public class Sedan extends Vehicle {

    private char trunkSize;

    public Sedan(Long carID, String vehicleType, String vehicleSubtype, int speed, double fuel, int seats,
                 int year, String driveTrain, int price, int quantity, char trunkSize) {
        super(carID, vehicleType, vehicleSubtype, speed, fuel, seats, year, driveTrain, price, quantity);

        this.trunkSize = trunkSize;

    }

    //getter
    public char getTrunkSize() {
        return trunkSize;
    }

    //setter
    public void setTrunkSize(char trunkSize) {
        this.trunkSize = trunkSize;
    }

    @Override
    public String formatForFile() {
        return getCarID() + ";" + getVehicleType() + ";" + getVehicleSubtype() + ";" + getSpeed() + ";" + getFuel() + ";" + getSeats() + ";" + getYear() + ";"
                + getDriveTrain() + ";" + getPrice() + ";" + getQuantity() + ";" + getTrunkSize();
    }

    @Override
    public String toString() {

        String trunk = "";
        if (getTrunkSize() == 'S') {
            trunk = "Small";
        } else if (getTrunkSize() == 'M')
            trunk = "Moderate";
        else if (getTrunkSize() == 'L') {
            trunk = "Large/spacious";
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
                        "Trunk Size: " + trunk;
    }
}

