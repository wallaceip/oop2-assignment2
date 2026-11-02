package problemdomain;

public class SUV extends Vehicle {

    public SUV(Long carID, String vehicleType, String vehicleSubtype, int speed, double fuel, int seats,
               int year, String driveTrain, int price, int quantity) {

        super(carID, vehicleType, vehicleSubtype, speed, fuel, seats, year, driveTrain, price, quantity);
    }

    @Override
    public String toString() {
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
                        "Available: \t" + getQuantity();
    }

}
