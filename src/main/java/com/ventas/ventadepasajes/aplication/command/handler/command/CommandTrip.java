package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandTrip {
    private double cost;
    private int seats_available;
    private int seats_sold;

    public CommandTrip(){}

    public CommandTrip(double cost, int seats_available, int seats_sold){
        this.cost = cost;
        this.seats_available = seats_available;
        this.seats_sold = seats_sold;
    }

    public double getCost(){ return this.cost;}

    public int getSeats_available(){return this.seats_available;}

    public int getSeats_sold(){return this.seats_sold;}
}
