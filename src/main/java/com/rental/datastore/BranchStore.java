package com.rental.datastore;

import com.rental.branch.Branch;
import com.rental.model.Vehicle;
import com.rental.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class BranchStore {

    private List<Branch> branches = new ArrayList<>();

    private VehicleStore vehicleStore;

    public Branch createBranch(String name){
        Branch branch = findBranch(name);
        if(branch != null){
            return branch;
        }
        branch = new Branch(branches.size(),name);
        branches.add(branch);
        return branch;
    }

    public Branch findBranch(String name){
        for(Branch branch:branches){
            if(branch.getBranchName().equals(name)){
                return branch;
            }
        }
        return null;
    }

    public List<Vehicle> findVehiclesByType(VehicleType vehicleType){
        List<Vehicle> vehicleList = new ArrayList<>();
        for(Branch branch:branches){
            vehicleStore = new VehicleStore(branch.getVehicleList());
            vehicleList.addAll(vehicleStore.findVehicleByType(vehicleType));
        }
        return vehicleList;
    }

    public List<Vehicle> findVehiclesByTypeAndBranch(VehicleType vehicleType, Branch branch){
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleStore = new VehicleStore(branch.getVehicleList());
        vehicleList.addAll(vehicleStore.findVehicleByType(vehicleType));
        return vehicleList;
    }

    public int allocatePrice(String branchName, VehicleType vehicleType, int price){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return -1;
        }else{
            vehicleStore = new VehicleStore(branch.getVehicleList());
            List<Vehicle> vehicleList = vehicleStore.findVehicleByType(vehicleType);
            if(vehicleList == null || vehicleList.size() ==0){
                return -1;
            }
            for(Vehicle vehicle:vehicleList){
                vehicle.setPrice(price);
            }
        }
        return 0;
    }

    public int addVehicleToBranch(String branchName, VehicleType vehicleType, int vehicleId){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return -1;
        }else{
            vehicleStore = new VehicleStore(branch.getVehicleList());
            vehicleStore.addVehicleToList(vehicleId,vehicleType);
        }
        return 0;
    }
}
