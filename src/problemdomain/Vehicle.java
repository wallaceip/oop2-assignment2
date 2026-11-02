package problemdomain;

public abstract class Vehicle {

    private Long carID; //change to Long
    private String vehicleType;
    private String vehicleSubtype;
    private int speed;
    private double fuel;
    private int seats;
    private int year;
    private String driveTrain;
    private int price; //change to int
    private int quantity;

    public Vehicle(Long carID, String vehicleType, String vehicleSubtype, int speed, double fuel, int seats,
                   int year, String driveTrain, int price, int quantity) {

        this.carID = carID;
        this.vehicleType = vehicleType;
        this.vehicleSubtype = vehicleSubtype;
        this.speed = speed;
        this.fuel = fuel;
        this.seats = seats;
        this.year = year;
        this.driveTrain = driveTrain;
        this.price = price;
        this.quantity = quantity;

    }

    //getters

    public Long getCarID() {
        return carID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleSubtype() {
        return vehicleSubtype;
    }

    public double getFuel() {
        return fuel;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSeats() {
        return seats;
    }

    public int getYear() {
        return year;
    }

    public String getDriveTrain() {
        return driveTrain;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    //setters

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleSubtype(String vehicleSubtype) {
        this.vehicleSubtype = vehicleSubtype;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void purchase() {

    }

    public String formatForFile() {
        return carID + ";" + vehicleType + ";" + vehicleSubtype + ";" + speed + ";" + fuel + ";" + seats + ";" + year + ";" + driveTrain + ";" + price + ";" + quantity;
    }

    public String toString() {
        return

                "Car ID: \t\t\n" + carID +
                        "Vehicle Type:\n" + vehicleType +
                        "Subtype: \t\n" + vehicleSubtype +
                        "Speed:\t\n" + speed +
                        "Fuel: \t\n" + fuel +
                        "Number of seats: \t\n" + seats +
                        "Year: \t\n" + year +
                        "DriveTrain: \t\n" + driveTrain + '\'' +
                        "Price: \t\n" + price +
                        "Available: \t" + quantity;
    }
}

