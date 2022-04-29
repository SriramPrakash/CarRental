package com.rental.model;


public class Vehicle {

    int id;
    VehicleType vehicleType;
    int bookingStartTime;
    int bookingEnd;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    int price;

    public Vehicle(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getBookingStartTime() {
        return bookingStartTime;
    }

    public void setBookingStartTime(int bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }

    public int getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(int bookingEnd) {
        this.bookingEnd = bookingEnd;
    }
}
