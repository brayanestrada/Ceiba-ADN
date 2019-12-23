package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;

public class CommandTripDataBuilder {

    private double cost;
    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private String tripDate;
    private long idDriver;
    private double ticketAmount;

    public CommandTripDataBuilder(){
        this.cost = 5000;
        this.seatsAvailable = 10;
        this.seatsSold = 0;
        this.startCity = "Medellín";
        this.endCity = "Armenia";
        this.tripDate = "12-12-2019";
        this.idDriver = 1;
        this.ticketAmount = 50000;
    }

    public CommandTrip build(){ return new CommandTrip(cost, seatsAvailable, seatsSold, startCity, endCity,idDriver, tripDate , ticketAmount);
    }
}
