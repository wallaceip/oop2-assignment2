package problemdomain;

import java.util.Objects;

public class Hybrid extends Vehicle {

    private String powerTrain;
    private int electricRange;

    public Hybrid(Long carID, String vehicleType, String vehicleSubtype, int speed, double fuel, int seats,
                  int year, String driveTrain, int price, int quantity, String powerTrain, int electricRange) {

        super(carID, vehicleType, vehicleSubtype, speed, fuel, seats, year, driveTrain, price, quantity);

        this.powerTrain = powerTrain;
        this.electricRange = electricRange;
    }
    //getters

    public String getPowerTrain() {
        return powerTrain;
    }

    public int getElectricRange() {
        return electricRange;
    }

    //setters

    public void setPowerTrain(String powerTrain) {
        this.powerTrain = powerTrain;
    }

    public void setElectricRange(int electricRange) {
        this.electricRange = electricRange;
    }

    @Override
    public String formatForFile() {
        return getCarID() + ";" + getVehicleType() + ";" + getVehicleSubtype() + ";" + getSpeed() + ";" + getFuel() + ";" + getSeats() + ";" + getYear() + ";"
                + getDriveTrain() + ";" + getPrice() + ";" + getQuantity() + ";" + getPowerTrain() + ";" + getElectricRange();
    }

    @Override
    public String toString() {

        String powerTrain ="";
        if (getPowerTrain().equals("E")) {
            powerTrain = "Series Hybrid";
        } else if (getPowerTrain().equals("A")){;
            powerTrain = "Parallel Hybrid";}
        else if (getPowerTrain().equals("PHEV")) {
            powerTrain = "Plug-in Hybrid";
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
                        "Power Train: " + powerTrain + "\n" +
                        "Electric Range: " + getElectricRange();
    }
}
