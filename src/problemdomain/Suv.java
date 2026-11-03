package problemdomain;

public class Suv extends Vehicle {

    //suv has no class specific attributes
    public Suv(long carID, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity) {
        super(carID, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
    }

    //override toString
    @Override
    public String toString() {
        return super.toString();
    }
}
