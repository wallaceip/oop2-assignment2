package problemdomain;

import java.util.Objects;

public class PickupTruck extends Vehicle {

    private String cargoBed;
    private int cargoCapacity;

    public PickupTruck(Long carID, String vehicleType, String vehicleSubtype, int speed, double fuel, int seats,
                       int year, String driveTrain, int price, int quantity, String cargoBed, int cargoCapacity) {

        super(carID, vehicleType, vehicleSubtype, speed, fuel, seats, year, driveTrain, price, quantity);

        this.cargoBed = cargoBed;
        this.cargoCapacity = cargoCapacity;
    }

    //getters

    public String getCargoBed() {
        return cargoBed;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    //setters

    public void setCargoBed(String cargoBed) {
        this.cargoBed = cargoBed;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String formatForFile() {
        return getCarID() + ";" + getVehicleType() + ";" + getVehicleSubtype() + ";" + getSpeed() + ";" + getFuel() + ";" + getSeats() + ";" + getYear() + ";"
                + getDriveTrain() + ";" + getPrice() + ";" + getQuantity() + ";" + getCargoBed() + ";" + getCargoCapacity();
    }

    @Override
    public String toString() {

        String cargoBed ="";

        if (getCargoBed().equals("SB")) {
            cargoBed = "Small Bed";
        } else if (getCargoBed().equals("EB")) {
            cargoBed = "Extended Bed";
        } else if  (getCargoBed().equals("DB")) {
            cargoBed = "Dump Bed";
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
                        "Cargo Bed: " + getCargoBed() + "\n" +
                        "Cargo Capacity: " + cargoBed;
    }

}
