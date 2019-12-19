package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandTrip {
    private double cost;
    private int seats_available;
    private int seats_sold;
    private String startCity;
    private String endCity;
    private long idDriver;

    public CommandTrip(){}

    public CommandTrip(double cost, int seats_available, int seats_sold, String startCity, String endCity, long idDriver){
        this.cost = cost;
        this.seats_available = seats_available;
        this.seats_sold = seats_sold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
    }

    public double getCost() {
        return cost;
    }

    public int getSeats_available() {
        return seats_available;
    }

    public int getSeats_sold() {
        return seats_sold;
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
}
