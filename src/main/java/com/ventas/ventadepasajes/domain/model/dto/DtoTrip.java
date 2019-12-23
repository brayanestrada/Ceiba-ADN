package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Trip;

public class DtoTrip {
    private long id;
    private double cost;
    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private String tripDate;
    private double ticketAmount;
    private long idDriver;

    public DtoTrip(){}

    public DtoTrip(Long id, double cost, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        this.id = id;
        this.cost = cost;
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
        this.tripDate = tripDate;
        this.ticketAmount = ticketAmount;
    }

    public static DtoTrip valueOf(Trip trip){
        DtoTrip dtoTrip = new DtoTrip();
        dtoTrip.setId(trip.getId());
        dtoTrip.setCost(trip.getCost());
        dtoTrip.setSeatsAvailable(trip.getSeatsAvailable());
        dtoTrip.setSeatsSold(trip.getSeatsSold());
        dtoTrip.setStartCity(trip.getStartCity());
        dtoTrip.setEndCity(trip.getEndCity());
        dtoTrip.setTripDate(trip.getTripDate());
        dtoTrip.setIdDriver(trip.getIdDriver());
        dtoTrip.setTicketAmount(trip.getTicketAmount());
        return dtoTrip;
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

    public long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(long idDriver) {
        this.idDriver = idDriver;
    }
}
