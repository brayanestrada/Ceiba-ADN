package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityTrip;

public class Trip {

    private static final int MIN_SEATS_AVAILABLE = 0;
    private static final int MIN_COST = 0;
    private static final String ERROR_MIN_SEATS_AVAILABLE = "The minimum available seats are " + MIN_SEATS_AVAILABLE;
    private static final String ERROR_MIN_COST = "The minimum trip cost is " + MIN_COST;
    private static final String ERROR_MANDATORY_COST = "Error: Trip cost is mandatory";
    private static final String ERROR_MANDATORY_SEATS_AVAILABLE = "Error: Seats available value is mandatory";
    private static final String ERROR_MANDATORY_SEATS_SOLD = "Error: Seats sold value is mandatory";

    private long id;
    private double cost;
    private int seats_available;
    private int seats_sold;
    private String startCity;
    private String endCity;
    private long idDriver;

    public Trip(){}

    public Trip(long id, double cost, int seats_available, int seats_sold, String startCity, String endCity, long idDriver){
        this.id = id;
        this.cost = cost;
        this.seats_available = seats_available;
        this.seats_sold = seats_sold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
        dataValidatorTrip();
    }

    public Trip(double cost, int seats_available, int seats_sold, String startCity, String endCity, long idDriver){
        this.cost = cost;
        this.seats_available = seats_available;
        this.seats_sold = seats_sold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
        dataValidatorTrip();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getSeats_available() {
        return seats_available;
    }

    public void setSeats_available(int seats_available) {
        this.seats_available = seats_available;
    }

    public int getSeats_sold() {
        return seats_sold;
    }

    public void setSeats_sold(int seats_sold) {
        this.seats_sold = seats_sold;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(long idDriver) {
        this.idDriver = idDriver;
    }

    private void dataValidatorTrip(){
        DataValidator.validateMandatory(cost, ERROR_MANDATORY_COST);
        DataValidator.validateMandatory(seats_available, ERROR_MANDATORY_SEATS_AVAILABLE);
        DataValidator.validateMandatory(seats_sold, ERROR_MANDATORY_SEATS_SOLD);
        DataValidator.validateMinimumValue(cost, MIN_SEATS_AVAILABLE, ERROR_MIN_COST);
        DataValidator.validateMinimumValue(seats_available, MIN_SEATS_AVAILABLE, ERROR_MIN_SEATS_AVAILABLE);
    }

    public static Trip valueOf(EntityTrip entityTrip){
        Trip trip = new Trip();
        trip.setId(entityTrip.getId());
        trip.setCost(entityTrip.getCost());
        trip.setSeats_available(entityTrip.getSeats_available());
        trip.setSeats_sold(entityTrip.getSeats_sold());
        trip.setStartCity(entityTrip.getStartCity());
        trip.setEndCity(entityTrip.getEndCity());
        trip.setIdDriver(entityTrip.getIdDriver());
        return trip;
    }
}
