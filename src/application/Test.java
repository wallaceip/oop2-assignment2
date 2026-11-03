package application;

import problemdomain.*;

public class Test {

    public static void main(String[] args) {
        Sedan sedan = new Sedan(121587921, "Sedan", "Luxury", 180, 50.0, 5, 2020, "AWD", 25000, 8, "L");
        Hatchback hatchback = new Hatchback(263914872,"Hatchback","Economy",160,45.0,5,2019,"FWD",18000,10,"p");
        Hybrid hybrid = new Hybrid(596387204,"Hybrid","Crossover",180,45.0,5,2022,"AWD",28000,6,"A",40);
        Suv suv = new Suv(374512039L, "SUV", "Compact", 160, 70.0, 7, 2018, "AWD", 35000, 4);
        PickupTruck truck = new PickupTruck(641289354L, "Pickup Truck", "Full-Size", 140, 80.0, 2, 2021, "4WD", 30000, 10, "EB", 1500);

        System.out.println(sedan + "\n");
        System.out.println(hatchback + "\n");
        System.out.println(hybrid + "\n");
        System.out.println(suv + "\n");
        System.out.println(truck + "\n");

    }
}
