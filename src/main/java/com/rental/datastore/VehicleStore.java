package com.rental.datastore;

import com.rental.branch.Branch;
import com.rental.model.Vehicle;
import com.rental.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehicleStore {

    private List<Vehicle> vehicleList;

    public VehicleStore(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> findVehicleByType(VehicleType vehicleType){
        List<Vehicle> vehicleByType = new ArrayList<>();
        for(Vehicle vehicle:vehicleList){
            if(vehicle.getVehicleType() == vehicleType){
                vehicleByType.add(vehicle);
            }
        }
        return vehicleByType;
    }

    public Vehicle findVehicleById(int vehicleId){
        for(Vehicle vehicle:vehicleList){
            if(vehicle.getId() == vehicleId){
                return vehicle;
            }
        }
        return null;
    }

    public Vehicle addVehicleToList(int id, VehicleType vehicleType){
        Vehicle vehicle = findVehicleById(id);
        if(vehicle == null){
            vehicle = new Vehicle(id,vehicleType);
            vehicleList.add(vehicle);
        }
        return vehicle;
    }
}
