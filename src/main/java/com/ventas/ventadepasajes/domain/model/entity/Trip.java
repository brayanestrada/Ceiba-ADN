package com.ventas.ventadepasajes.domain.model.entity;

public class Trip {

    private static final int MIN_SEATS_AVAILABLE = 0;
    private static final String ERROR_MIN_SEATS_AVAILABLE = "The minimum available seats are " + MIN_SEATS_AVAILABLE;
    private static final String ERROR_MANDATORY_SEATS_AVAILABLE = "Error: Seats available value is mandatory";
    private static final String ERROR_DATE_FORMAT = "Error: Date format is not correct, it must be dd-MM-yyyy";
    private static final String ERROR_START_CITY_MANDATORY = "Error: Start city is mandatory";
    private static final String ERROR_END_CITY_MANDATORY = "Error: End city is mandatory";
    private static final String ERROR_ID_DRIVER_MANDATORY = "Error: Driver id is mandatory";

    private long idModel;
    private long idDriverModel;
    private int seatsAvailableModel;
    private int seatsSoldModel;
    private String tripDateModel;
    private double ticketAmountModel;
    private String startCityModel;
    private String endCityModel;

    private Trip(){}

    public Trip(long id, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        dataValidatorTrip(seatsAvailable, tripDate, startCity, endCity, idDriver);
        this.idModel = id;
        this.endCityModel = endCity;
        this.seatsSoldModel = seatsSold;
        this.tripDateModel = tripDate;
        this.startCityModel = startCity;
        this.idDriverModel = idDriver;
        this.seatsAvailableModel = seatsAvailable;
        this.ticketAmountModel = ticketAmount;
    }

    public Trip( int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        dataValidatorTrip(seatsAvailable, tripDate, startCity, endCity, idDriver);
        this.seatsAvailableModel = seatsAvailable;
        this.seatsSoldModel = seatsSold;
        this.idDriverModel = idDriver;
        this.endCityModel = endCity;
        this.startCityModel = startCity;
        this.ticketAmountModel = ticketAmount;
        this.tripDateModel = tripDate;
    }

    public long getId() {
        return idModel;
    }

    public int getSeatsAvailable() {
        return seatsAvailableModel;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailableModel = seatsAvailable;
    }

    public int getSeatsSold() {
        return seatsSoldModel;
    }

    public void setSeatsSold(int seatsSold) {
        this.seatsSoldModel = seatsSold;
    }

    public String getStartCity() {
        return startCityModel;
    }

    public String getEndCity() {
        return endCityModel;
    }

    public long getIdDriver() {
        return idDriverModel;
    }

    public String getTripDate() {
        return tripDateModel;
    }

    public double getTicketAmount() {
        return ticketAmountModel;
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
