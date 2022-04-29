package com.rental.branch;

import com.rental.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    int branchid;
    String branchName;

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void addVehicle(Vehicle vehicle) {
        getVehicleList().add(vehicle);
    }

    List<Vehicle> vehicleList;


    public Branch(int branchid, String branchName) {
        this.branchid = branchid;
        this.vehicleList = new ArrayList<>();
        this.branchName = branchName;
    }


    public int getBranchid() {
        return branchid;
    }

    private void setBranchid(int branchid) {
        this.branchid = branchid;
    }

    public String getBranchName() {
        return branchName;
    }

    private void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
