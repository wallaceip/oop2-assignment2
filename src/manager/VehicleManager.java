package manager;

import problemdomain.*;

import java.io.*;
import java.util.*;

public class VehicleManager {

    private final String FILENAME = "res/vehicles.txt";
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);
    int carID = 0;
    int choice = 0;
    boolean validEntry = false;

    private void loadVehicles() {
        Scanner inFile = null;

        try {

            //load info from file
            inFile = new Scanner(new File(FILENAME));

            //while lines are in the file, parse out parts by colon, if part[0] starts with specific character
            // add line to list

            while (inFile.hasNext()) {

                String line = inFile.nextLine();
                String[] parts = line.split(";");
                String carID = parts[0];
                char firstDigit = carID.charAt(0);

                if (firstDigit == '1') {

                    Vehicle sedan = new Sedan(

                            Long.parseLong(parts[0]), //car ID
                            parts[1], //type
                            parts[2], //subtype
                            Integer.parseInt(parts[3]), //speed
                            Double.parseDouble(parts[4]), //fuel
                            Integer.parseInt(parts[5]), //seats
                            Integer.parseInt(parts[6]), //year
                            parts[7],                   //drivetrain
                            Integer.parseInt(parts[8]), //price
                            Integer.parseInt(parts[9]),//quantity
                            parts[10].charAt(0));


                    vehicles.add(sedan);
                } else if (firstDigit == '2') {

                    Vehicle hatchback = new Hatchback(
                            Long.parseLong(parts[0]), //car ID
                            parts[1], //type
                            parts[2], //subtype
                            Integer.parseInt(parts[3]), //speed
                            Double.parseDouble(parts[4]), //fuel
                            Integer.parseInt(parts[5]), //seats
                            Integer.parseInt(parts[6]), //year
                            parts[7], //drivetrain
                            Integer.parseInt(parts[8]), //price
                            Integer.parseInt(parts[9]), //quantity
                            parts[10].charAt(0)); //hatchtype
                    vehicles.add(hatchback);

                } else if (firstDigit == '3') {

                    Vehicle suv = new SUV(
                            Long.parseLong(parts[0]), //id
                            parts[1], //type
                            parts[2], //subtype
                            Integer.parseInt(parts[3]), //speed
                            Double.parseDouble(parts[4]), //fuel
                            Integer.parseInt(parts[5]),  //seats
                            Integer.parseInt(parts[6]), //year
                            parts[7], //drivetrain
                            Integer.parseInt(parts[8]), //price
                            Integer.parseInt(parts[9])); //quantity

                    vehicles.add(suv);

                } else if (firstDigit == '4' || firstDigit == '5') {

                    Vehicle hybrid = new Hybrid(

                            Long.parseLong(parts[0]), //id
                            parts[1], //type
                            parts[2],//subtype
                            Integer.parseInt(parts[3]), //speed
                            Double.parseDouble(parts[4]), //fuel
                            Integer.parseInt(parts[5]), //seats
                            Integer.parseInt(parts[6]), //year
                            parts[7], //drivetrain
                            Integer.parseInt(parts[8]), //price
                            Integer.parseInt(parts[9]), //quantity
                            parts[10], //powertrain
                            Integer.parseInt(parts[11])); //electric range

                    vehicles.add(hybrid);
                } else {

                    Vehicle pickupTruck = new PickupTruck(
                            Long.parseLong(parts[0]), //id
                            parts[1], //type
                            parts[2], //subtype
                            Integer.parseInt(parts[3]), //speed
                            Double.parseDouble(parts[4]), //fuel
                            Integer.parseInt(parts[5]), //seats
                            Integer.parseInt(parts[6]), //year
                            parts[7], //drivetrain
                            Integer.parseInt(parts[8]), //price
                            Integer.parseInt(parts[9]), //quantity
                            parts[10], //cargo-bed
                            Integer.parseInt(parts[11])); //cargo-capacity


                    vehicles.add(pickupTruck);

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        inFile.close();
    }

    private int getValidPositiveInt(String prompt) {
        int value = 0;
        boolean valid = false;

        //repeat until a valid positive integer is inputted
        while (!valid) {
            System.out.print(prompt);
            String input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);
                if (value > 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid input. Value cannot be zero or negative.");
                }
            } catch (NumberFormatException e) {
                //handles non-integer input
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return value;
    }

    public void purchaseVehicle() {

        boolean found = false; //set to true when carID is found in array list
        boolean purchased = false; //set to true when quantity is available

        carID = getValidPositiveInt("Enter CarID: "); //ask for car ID

        for (Vehicle vehicle : vehicles) {  //iterate through vehicle list

            if ((vehicle.getCarID() == (long) carID)) { //check if entered carID matches any of the vehicle's car IDs
                found = true; //set to true if there's a match

                if (vehicle.isAvailable()) { //check if car is in stock, subtract one if it is
                    vehicle.setQuantity(vehicle.getQuantity() - 1);
                    purchased = true;
                    System.out.println("The vehicle " + vehicle.getVehicleType() + " " + vehicle.getVehicleSubtype() + " has been purchased");

                } else {
                    System.out.println("That vehicle is currently out of stock.");

                }
            }
        }

        if (!found) {
            System.out.println("Invalid CarID entered.");
        }

    }

    public void selectVehicleType() {

        System.out.println("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid");

        String vehicleType = keyboard.nextLine();
        boolean validVehicleType = false; //checking for valid vehicle type

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                System.out.println(vehicle);
                validVehicleType = true;
            }
        }

        if (!validVehicleType) {
            System.out.println("Invalid vehicle type entered");
        }
    }

    public void generateRandomVehicleList() {

        //prompt user for number of vehicles
        int numVehicles = 0;

        while (numVehicles <= 0 || numVehicles > vehicles.size()) {
            numVehicles = getValidPositiveInt("Enter number of vehicles: ");

            if (numVehicles > vehicles.size()) {
                System.out.println("Invalid input. Number of vehicles cannot exceed " + vehicles.size() + ".");
            }
        }

        //shuffle the vehicle list
        Collections.shuffle(vehicles);

        //print the random vehicle list
        System.out.println("Vehicle List");

        //loop through and print vehicles from the shuffled list
        for (int i = 0; i < numVehicles && i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i));
        }

    }

    public void sedanSelected() {

        String trunkSizeInput;
        System.out.println("Enter trunk size (L for Large/Spacious Trunk, S for Small Trunk, or M for Moderate Trunk): ");
        trunkSizeInput = keyboard.nextLine().toUpperCase();
        char trunkSize = trunkSizeInput.charAt(0);

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i) instanceof Sedan) {
                Sedan sedan = (Sedan) vehicles.get(i);
                if (trunkSize == sedan.getTrunkSize()) {
                    validEntry=true;
                    System.out.println("Matching Vehicles:");
                    System.out.println(sedan);

                }
            }
        }

        if (!validEntry) {
            System.out.println("Invalid Entry");
        }
    }

    public void hatchBackSelected() {

        String hatchTypleInput;
        System.out.println("Enter trunk size (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
        hatchTypleInput = keyboard.nextLine().toUpperCase();
        char hatchType = hatchTypleInput.charAt(0);

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i) instanceof Hatchback) {
                Hatchback hatchback = (Hatchback) vehicles.get(i);
                if (hatchType == hatchback.getHatchType()) {
                    validEntry = true;
                    System.out.print("Matching Vehicles:");
                    System.out.println(hatchback);
                }
            }
        }
        if (!validEntry) {
            System.out.println("Invalid Entry");
        }
    }

    public void suvSelected() {

        System.out.println("Enter drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive): ");
        String driveTrainInput = keyboard.nextLine().toUpperCase();

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i) instanceof SUV) {
                SUV suv = (SUV) vehicles.get(i);
                if (driveTrainInput.equals(suv.getDriveTrain())) {
                    validEntry = true;
                    System.out.print("Matching Vehicles:");
                    System.out.println(suv);
                }
            }
        }

        if (!validEntry) {
            System.out.println("Invalid Entry");
        }

    }

    public void hybridSelected() {

        String powerTrainInput;
        System.out.println("Enter a powertrain (E for Series Hybrid, A for Parallel Hybrid, PHEV for Plug-in): ");
        powerTrainInput = keyboard.nextLine().toUpperCase();

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i) instanceof Hybrid) {
                Hybrid hybrid = (Hybrid) vehicles.get(i);
                if (powerTrainInput.equals(hybrid.getPowerTrain())) {
                    validEntry = true;
                    System.out.print("Matching Vehicles:");
                    System.out.println(hybrid);
                }
            }
        }

        if (!validEntry) {
            System.out.println("Invalid Entry");
        }

    }

    public void pickupTruckSelected() {

        String cargoBedInput;
        System.out.println("Enter trunk size (SB for Short Bed, EB for Extended Bed, or DB for Dump Bed): ");
        cargoBedInput = keyboard.nextLine().toUpperCase();

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i) instanceof PickupTruck) {
                PickupTruck pickupTruck = (PickupTruck) vehicles.get(i);
                if (cargoBedInput.equals(pickupTruck.getCargoBed())) {
                    validEntry = true;
                    System.out.print("Matching vehicles:");
                    System.out.println(pickupTruck);
                }
            }
        }

        if (!validEntry) {
            System.out.println("Invalid Entry");
        }
    }

    private void saveVehicleListToFile() {
        try {
            PrintWriter writer = new PrintWriter(FILENAME);

            for (Vehicle vehicle : vehicles) {
                writer.println(vehicle.formatForFile());
            }

            writer.close();

            System.out.println("Vehicle list saved to vehicles.txt. Exiting program.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void vehicleTypeSubMenu() {

        while (choice != 6) {
            //display menu with formatted options
            System.out.println("# Vehicle Type");
            System.out.printf("%-5s%s%n", "1", "Sedan");
            System.out.printf("%-5s%s%n", "2", "Hatchback");
            System.out.printf("%-5s%s%n", "3", "SUV");
            System.out.printf("%-5s%s%n", "4", "Hybrid");
            System.out.printf("%-5s%s%n", "5", "Pickup Truck");
            System.out.printf("%-5s%s%n", "6", "Back to Main Menu");
            choice = getValidPositiveInt("Enter type of vehicle (or 6 to exit): ");

            switch (choice) {
                case 1:
                    sedanSelected();
                    break;
                case 2:
                    hatchBackSelected();
                    break;
                case 3:
                    suvSelected();
                    break;
                case 4:
                    hybridSelected();
                    break;
                case 5:
                    pickupTruckSelected();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void displayMenu() {

        while (choice != 5) {
            //display menu with formatted options
            System.out.println("\nWelcome to Drive Masters");
            System.out.println("Please choose any option below");
            System.out.println("-------------------------------");
            System.out.printf("%-5s%s%n", "1", "Purchase Vehicle");
            System.out.printf("%-5s%s%n", "2", "Display Vehicles by Type");
            System.out.printf("%-5s%s%n", "3", "Display Vehicles by Type-Specific Attribute");
            System.out.printf("%-5s%s%n", "4", "Produce a Random List of Vehicles");
            System.out.printf("%-5s%s%n", "5", "Save & Exit");
            System.out.print("Enter option: ");

            choice = getValidPositiveInt("Enter option: ");

            switch (choice) {
                case 1:
                    purchaseVehicle(); //done
                    break;
                case 2:
                    selectVehicleType(); //done
                    break;
                case 3:
                    vehicleTypeSubMenu(); //almost done, add input validations, exit back to main menu?
                    break;
                case 4:
                    generateRandomVehicleList(); //done
                    break;
                case 5:
                    saveVehicleListToFile();//done
                    break;
                default:
                    System.out.println("Invalid option!"); //done
                    break;
            }
        }
    }

    public void vehicleManger() {

        loadVehicles();
        displayMenu();

    }


}
