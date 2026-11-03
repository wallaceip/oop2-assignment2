package manager;

import problemdomain.*;

import java.io.*;
import java.util.*;

public class VehicleManager {
    //constants
    private final String FILE_NAME = "res/vehicles.txt";
    //attributes
    private ArrayList<Vehicle> vehicles;
    private Scanner userInput = new Scanner(System.in);

    public VehicleManager() {
        loadVehiclesList();
        displayMenu();
    }
    //loadingFromDataFile into an ArrayList
    //displayMenu to display UI menu
    //savingDataToFile

    private void loadVehiclesList() {
        vehicles = new ArrayList<>();
        try (Scanner inFile = new Scanner(new File(FILE_NAME))) {
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                // Note: Check if your employees.txt uses ";" or "," as the delimiter
                String[] parts = line.split(";");
                String carID = parts[0];
                char firstDigit = carID.charAt(0);

                switch (firstDigit) {
                    case '1':
                        Sedan sedan = new Sedan(
                                Long.parseLong(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]),
                                Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), parts[10]
                        );
                        vehicles.add(sedan);
                        break;

                    case '2':
                        Hatchback hatchback = new Hatchback(
                                Long.parseLong(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]),
                                Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), parts[10]
                        );
                        vehicles.add(hatchback);
                        break;

                    case '3':
                        Suv suv = new Suv(
                                Long.parseLong(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]),
                                Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9])
                        );
                        vehicles.add(suv);
                        break;

                    case '4':
                    case '5':
                        Hybrid hybrid = new Hybrid(
                                Long.parseLong(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]),
                                Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), parts[10], Integer.parseInt(parts[11])
                        );
                        vehicles.add(hybrid);
                        break;

                    case '6':
                        PickupTruck pickupTruck = new PickupTruck(
                                Long.parseLong(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]),
                                Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), parts[10], Integer.parseInt(parts[11])
                        );
                        vehicles.add(pickupTruck);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayMenu() {

        int choice;

        do {

            System.out.println("Welcome to Drive Masters");
            System.out.println("Please choose any option below");
            System.out.println("-------------------------------");
            System.out.println("1\tPurchase Vehicle");
            System.out.println("2\tDisplay Vehicles by Type");
            System.out.println("3\tDisplay Vehicles by Type-Specific Attribute");
            System.out.println("4\tProduce a Random List of Vehicles");
            System.out.println("5\tSave & Exit");

            System.out.print("\nEnter option: ");
            choice = userInput.nextInt();
            userInput.nextLine();

            switch (choice) {
                case 1:
                    purchaseVehicle();
                    break;
                case 2:
                    displayVehiclesByType();
                    break;
                case 3:
                    displayVehiclesByTypeAttribute();
                    break;
                case 4:
                    displayRandomVehicles();
                    break;
                case 5:
                    saveVehiclesList();
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }


    public void purchaseVehicle() {
        System.out.print("Enter CarID: ");
        long carID = userInput.nextLong();
        userInput.nextLine();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getCarID() == carID) {

                if (vehicle.isAvailable()) {
                    vehicle.purchase(); //purchase vehicle and decrease quantity

                    System.out.println("\nThe Vehicle \"" + vehicle.getVehicleType() + " " + vehicle.getSubType() + "\" has been purchased.");

                } else {
                    System.out.println("Vehicle is currently unavailable.");
                }
                return;
            }
        }
        System.out.println("Vehicle with CarID " + carID + " not found.");
    }

    public void displayVehiclesByType() {
        //prompt user to enter a vehicle type
        System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid) ");
        String vehicleType = userInput.nextLine();

        //track whether any matching vehicles are found
        boolean found = false;


        for (Vehicle vehicle : vehicles) {
            //compare vehicle types and ignore capitalization
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {

                //display heading before first matching vehicle
                if (!found) {
                    System.out.println("\nMatching vehicles:");
                }

                //display matching vehicle
                System.out.println(vehicle + "\n");

                found = true;
            }
        }

        //display a message if no vehicles match the search
        if (!found) {
            System.out.println("No matching vehicles found.");
        }
    }

    public void displayVehiclesByTypeAttribute() {
        //display vehicle selection menu
        System.out.println("# Vehicle Type");
        System.out.println("1\tSedan");
        System.out.println("2\tHatchback");
        System.out.println("3\tSUV");
        System.out.println("4\tHybrid");
        System.out.println("5\tPickup Truck");

        //get selected vehicle type
        System.out.print("\nEnter type of vehicle: ");
        int vehicleChoice = userInput.nextInt();
        userInput.nextLine();

        // Store the attribute selected by the user
        String attribute;

        // Prompt for the selected vehicle's specific attribute
        switch (vehicleChoice) {
            case 1:
                System.out.print("Enter trunk size (L for Large/Spacious Trunk, S for Small Trunk, or M for Moderate Trunk): ");
                break;
            case 2:
                System.out.print("Enter hatch type (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
                break;
            case 3:
                System.out.print("Enter drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive): ");
                break;
            case 4:
                System.out.print("Enter a powertrain (E for Series Hybrid, A for Parallel Hybrid, PHEV for Plug-in Hybrid): ");
                break;
            case 5:
                System.out.print("Enter cargo bed type (SB for Short Bed, EB for Extended Bed, or DB for Dump Bed): ");
                break;
            default:
                System.out.println("Invalid vehicle type selected.");
                return;
        }

        //read the attribute entered by the user
        attribute = userInput.nextLine();
        //track if any matching vehicles are found
        boolean found = false;
        //loop through all vehicles
        for (Vehicle vehicle : vehicles) {
            boolean matches = false;
            switch (vehicleChoice){
                case 1:
                    //check sedan trunk size
                    if (vehicle instanceof Sedan) {
                        Sedan sedan = (Sedan) vehicle;
                        matches = sedan.getTrunkSize().equalsIgnoreCase(attribute);
                    }
                    break;
                case 2:
                    if (vehicle instanceof Hatchback) {
                        Hatchback hatchback = (Hatchback) vehicle;
                        matches = hatchback.getHatchType().equalsIgnoreCase(attribute);
                    }
                    break;
                case 3:
                    //check suv drivetrain
                    if (vehicle instanceof Suv){
                        Suv suv = (Suv) vehicle;
                        matches = suv.getDriveTrain().equalsIgnoreCase(attribute);
                    }
                    break;
                case 4:
                    if (vehicle instanceof Hybrid) {
                        Hybrid hybrid = (Hybrid) vehicle;
                        matches = hybrid.getPowertrain().equalsIgnoreCase(attribute);
                    }
                    break;
                case 5:
                    if (vehicle instanceof PickupTruck) {
                        PickupTruck pickupTruck = (PickupTruck) vehicle;
                        matches = pickupTruck.getCargoBedType().equalsIgnoreCase(attribute);
                    }
                    break;
            }

            //display vehicles that match the selected attribute
            if (matches) {
                //display heading once
                if (!found) {
                    System.out.println("\nMatching Vehicles:");
                }

                //display matching vehicle information0
                System.out.println(vehicle + "\n");
                found = true;
            }
        }

        //display message if no matching vehicles found
        if (!found) {
            System.out.println("No matching vehicles found.");
        }
    }

    public void displayRandomVehicles() {
        //prompt user for amount of vehicles
        System.out.print("Enter number of vehicles to display: ");
        if (!userInput.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            userInput.nextLine();
            return;
        }
        int numberOfVehicles = userInput.nextInt();
        userInput.nextLine();

        //checks if requested number is within inventory size
        if (numberOfVehicles < 1 || numberOfVehicles > vehicles.size()) {
            System.out.println("Please enter a number between 1 and " + vehicles.size() + ".");
            return;
        }
        //shuffle a copy so the original inventory order stays unchanged
        ArrayList<Vehicle> randomVehicles = new ArrayList<>(vehicles);
        Collections.shuffle(randomVehicles);

        System.out.println("\nRandom Vehicles:");
        for (int i = 0; i < numberOfVehicles; i++) {
            System.out.println(randomVehicles.get(i));
            System.out.println("\n----------------------------------");
        }
    }

    private void saveVehiclesList() {
        System.out.print("Saving Vehicles... ");

        try (PrintWriter outFile = new PrintWriter(new File(FILE_NAME))) {
            //write every vehicle in the same format
            for (Vehicle vehicle : vehicles) {
                String line = vehicle.getCarID() + ";" + vehicle.getVehicleType() + ";" +
                        vehicle.getSubType() + ";" + vehicle.getSpeed() + ";" +
                        vehicle.getFuel() + ";" + vehicle.getSeats() + ";" +
                        vehicle.getYear() + ";" + vehicle.getDriveTrain() + ";" +
                        vehicle.getPrice() + ";" + vehicle.getQuantity();

                // Append attributes that belong only to specific vehicle types
                if (vehicle instanceof Sedan) {
                    line += ";" + ((Sedan) vehicle).getTrunkSize();
                } else if (vehicle instanceof Hatchback) {
                    line += ";" + ((Hatchback) vehicle).getHatchType();
                } else if (vehicle instanceof Hybrid) {
                    Hybrid hybrid = (Hybrid) vehicle;
                    line += ";" + hybrid.getPowertrain() + ";" + hybrid.getElectricRange();
                } else if (vehicle instanceof PickupTruck) {
                    PickupTruck pickupTruck = (PickupTruck) vehicle;
                    line += ";" + pickupTruck.getCargoBedType() + ";" + pickupTruck.getCargoCapacity();
                }
                // SUVs have no additional attributes

                outFile.println(line);
            }

            // PrintWriter requires an explicit error check for failed writes
            outFile.flush();
            if (outFile.checkError()) {
                System.out.println("Failed to write the vehicle file.");
                return;
            }

            System.out.println("Done!");
            System.out.println("\nGoodbye!");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save vehicles.txt: " + e.getMessage());
        }
    }

}

