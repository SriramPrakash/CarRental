package com.rental;

import com.rental.api.RentalService;
import com.rental.model.Vehicle;
import com.rental.model.VehicleType;

public class RentalClient {

    private static RentalService rentalService = new RentalService();

    public static void main(String[] args){
        rentalService.addBranch("CP");
        rentalService.addBranch("Vasant Vihar");

        rentalService.addVehicle(123, VehicleType.HATCHBACK.name(), "CP");
        rentalService.addVehicle(234, VehicleType.SUV.name(), "CP");
        rentalService.addVehicle(345, VehicleType.HATCHBACK.name(), "Vasant Vihar");
        //rentalService.addVehicle(456, VehicleType.SEDAN.name(), "Vasant Vihar");
        rentalService.addVehicle(567, VehicleType.SUV.name(), "Vasant Vihar");
        rentalService.addVehicle(789, VehicleType.SUV.name(), "Vasant Vihar");
        rentalService.addVehicle(890, VehicleType.SUV.name(), "Vasant Vihar");
        rentalService.addVehicle(1111, VehicleType.SUV.name(), "Vasant Vihar");
        rentalService.addVehicle(2222, VehicleType.SUV.name(), "Vasant Vihar");
        rentalService.addVehicle(3333, VehicleType.SUV.name(), "Vasant Vihar");

        rentalService.allocatePrice("CP", VehicleType.HATCHBACK.name(), 100);
        rentalService.allocatePrice("CP", VehicleType.SEDAN.name(), 200);
        rentalService.allocatePrice("CP", VehicleType.SUV.name(), 500);

        rentalService.allocatePrice("Vasant Vihar", VehicleType.HATCHBACK.name(), 100);
        rentalService.allocatePrice("Vasant Vihar", VehicleType.SEDAN.name(), 200);
        rentalService.allocatePrice("Vasant Vihar", VehicleType.SUV.name(), 300);

        Vehicle vehicle = rentalService.bookVehicle(VehicleType.SUV.name(), 0,100);
        Vehicle vehicle2 = rentalService.bookVehicle(VehicleType.SEDAN.name(), 100,200);
        Vehicle vehicle3 = rentalService.bookVehicle(VehicleType.HATCHBACK.name(), 100,200);

    }
}
