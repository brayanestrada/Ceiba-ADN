package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandTrip {
    private double cost;
    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private String tripDate;
    private long idDriver;
    private double ticketAmount;

    public CommandTrip(double cost, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        this.cost = cost;
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
        this.tripDate = tripDate;
        this.ticketAmount = ticketAmount;
    }

    public double getCost() {
        return cost;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public int getSeatsSold() {
        return seatsSold;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public long getIdDriver() {
        return idDriver;
    }

    public String getTripDate() {
        return tripDate;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }
}