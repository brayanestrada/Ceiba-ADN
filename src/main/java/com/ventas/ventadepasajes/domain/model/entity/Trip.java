package com.ventas.ventadepasajes.domain.model.entity;

public class Trip {

    private static final int MIN_SEATS_AVAILABLE = 0;
    private static final String ERROR_MIN_SEATS_AVAILABLE = "The minimum available seats are " + MIN_SEATS_AVAILABLE;
    private static final String ERROR_MANDATORY_SEATS_AVAILABLE = "Error: Seats available value is mandatory";
    private static final String ERROR_DATE_FORMAT = "Error: Date format is not correct, it must be dd-MM-yyyy";
    private static final String ERROR_START_CITY_MANDATORY = "Error: Start city is mandatory";
    private static final String ERROR_END_CITY_MANDATORY = "Error: End city is mandatory";
    private static final String ERROR_ID_DRIVER_MANDATORY = "Error: Driver id is mandatory";

    private long id;
    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private String tripDate;
    private long idDriver;
    private double ticketAmount;

    private Trip(){}

    public Trip(long id, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        dataValidatorTrip(seatsAvailable, tripDate, startCity, endCity, idDriver);
        this.id = id;
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.tripDate = tripDate;
        this.idDriver = idDriver;
        this.ticketAmount = ticketAmount;
    }

    public Trip( int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        dataValidatorTrip(seatsAvailable, tripDate, startCity, endCity, idDriver);
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.tripDate = tripDate;
        this.idDriver = idDriver;
        this.ticketAmount = ticketAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    private void dataValidatorTrip(int seatsAvailable, String tripDate, String startCity, String endCity, long idDriver){
        DataValidator.validateNumberMandatory(seatsAvailable, ERROR_MANDATORY_SEATS_AVAILABLE);
        DataValidator.validateMandatory(startCity, ERROR_START_CITY_MANDATORY);
        DataValidator.validateMandatory(endCity, ERROR_END_CITY_MANDATORY);
        DataValidator.validateNumberMandatory(idDriver, ERROR_ID_DRIVER_MANDATORY);
        DataValidator.validateMinimumValue(seatsAvailable, MIN_SEATS_AVAILABLE, ERROR_MIN_SEATS_AVAILABLE);
        DataValidator.validateDateFormat(tripDate, ERROR_DATE_FORMAT);
    }
}
