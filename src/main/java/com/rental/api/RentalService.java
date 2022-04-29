package com.rental.api;

import com.rental.branch.Branch;
import com.rental.datastore.BranchStore;
import com.rental.model.Vehicle;
import com.rental.model.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RentalService {

    private static BranchStore branchStore = new BranchStore();

    public void addBranch(String branchName){
        branchStore.createBranch(branchName);
    }

    public int allocatePrice(String branchName, String vehicleType, int price){
        int returnCode = branchStore.allocatePrice(branchName, VehicleType.valueOf(vehicleType), price);
        if(returnCode == -1)
            return 404;
        return 200;
    }

    public int addVehicle(int vehicleId, String vehicleType, String branchName){
        int returnCode = branchStore.addVehicleToBranch(branchName,VehicleType.valueOf(vehicleType),vehicleId);
        if(returnCode == -1)
            return 404;
        return 200;
    }

    public Vehicle bookVehicle(String vehicleType, int startTime, int endTime){
        return bookVehicleByBranch(vehicleType,startTime,endTime,null);
    }

    private Vehicle bookVehicleByBranch(String vehicleType, int startTime, int endTime, String branchName) {
        List<Vehicle> vehicleList = null;
        if(branchName == null){
            vehicleList = branchStore.findVehiclesByType(VehicleType.valueOf(vehicleType));
        }else{
            Branch branch = branchStore.findBranch(branchName);
            vehicleList = branchStore.findVehiclesByTypeAndBranch(VehicleType.valueOf(vehicleType),branch);
        }
        List<Vehicle> availableVehicles = vehicleList.stream().filter($ -> $.getBookingEnd() == 0
                && $.getBookingStartTime() == 0).collect(Collectors.toList());
        if(availableVehicles == null || availableVehicles.size() ==0){
            return null;
        }
        availableVehicles.sort((a,b)->
                {if (a.getPrice()>b.getPrice())
                    return 1;
                else
                    return -1;
                });
        Vehicle vehicle = availableVehicles.get(0);
        vehicle.setBookingStartTime(startTime);
        vehicle.setBookingEnd(endTime);
        return vehicle;
    }

   /* private List<Vehicle> viewVehicleInventory(int startTime, int endTime) {
        List<Vehicle> vehicleList = null;
        if(branchName == null){
            vehicleList = branchStore.findVehiclesByType(VehicleType.valueOf(vehicleType));
        }else{
            Branch branch = branchStore.findBranch(branchName);
            vehicleList = branchStore.findVehiclesByTypeAndBranch(VehicleType.valueOf(vehicleType),branch);
        }
        vehicleList.sort((a,b)->
        {if (a.getPrice()>b.getPrice())
            return 1;
        else
            return -1;
        });
        Vehicle vehicle = vehicleList.get(0);
        vehicle.setBookingStartTime(startTime);
        vehicle.setBookingEnd(endTime);
        return vehicle;
    }*/

}
