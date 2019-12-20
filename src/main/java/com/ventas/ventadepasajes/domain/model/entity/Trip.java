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
    private static final String ERROR_DATE_FORMAT = "Error: Date format is not correct, it must be dd-MM-yyyy";

    private long id;
    private double cost;
    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private String tripDate;
    private long idDriver;
    private double ticketAmount;

    public Trip(){}

    public Trip(long id, double cost, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        this.id = id;
        this.cost = cost;
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.tripDate = tripDate;
        this.idDriver = idDriver;
        this.ticketAmount = ticketAmount;
        dataValidatorTrip();
    }

    public Trip(double cost, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        this.cost = cost;
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.tripDate = tripDate;
        this.idDriver = idDriver;
        this.ticketAmount = ticketAmount;
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

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public int getSeatsSold() {
        return seatsSold;
    }

    public void setSeatsSold(int seatsSold) {
        this.seatsSold = seatsSold;
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

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(double ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    private void dataValidatorTrip(){
        DataValidator.validateMandatory(cost, ERROR_MANDATORY_COST);
        DataValidator.validateMandatory(seatsAvailable, ERROR_MANDATORY_SEATS_AVAILABLE);
        DataValidator.validateMandatory(seatsSold, ERROR_MANDATORY_SEATS_SOLD);
        DataValidator.validateMinimumValue(cost, MIN_SEATS_AVAILABLE, ERROR_MIN_COST);
        DataValidator.validateMinimumValue(seatsAvailable, MIN_SEATS_AVAILABLE, ERROR_MIN_SEATS_AVAILABLE);
        DataValidator.validateDateFormat(tripDate, ERROR_DATE_FORMAT);
    }

    public static Trip valueOf(EntityTrip entityTrip){
        Trip trip = new Trip();
        trip.setId(entityTrip.getId());
        trip.setCost(entityTrip.getCost());
        trip.setIdDriver(entityTrip.getIdDriver());
        trip.setStartCity(entityTrip.getStartCity());
        trip.setSeatsAvailable(entityTrip.getSeatsAvailable());
        trip.setSeatsSold(entityTrip.getSeatsSold());
        trip.setEndCity(entityTrip.getEndCity());
        trip.setTripDate(entityTrip.getTripDate());
        trip.setTicketAmount(entityTrip.getTicketAmount());
        return trip;
    }
}
