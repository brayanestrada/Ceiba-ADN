package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;

public class CommandTripDataBuilder {

    private static final int seatsAvailable = 10;
    private static final int seatsSold = 0;
    private static final String startCity = "Medellín";
    private static final String endCity = "Armenia";
    private static final long idDriver = 1;
    private static final String tripDate = "12-12-2019";
    private static final double ticketAmount = 50000;
    private static final String badTripDate = "12/12/2019";
    private static final int minimumSeatsAvailable = 0;

    public CommandTrip build(){ return new CommandTrip(seatsAvailable, seatsSold, startCity, endCity,idDriver, tripDate , ticketAmount); }

    public CommandTrip buildWithoutSeatsAvailable(){ return new CommandTrip(seatsAvailable, seatsSold, startCity, endCity, idDriver, tripDate, ticketAmount);}

    public CommandTrip buildWithoutStartCity(){ return new CommandTrip(seatsAvailable, seatsSold, startCity, endCity, idDriver, tripDate, ticketAmount);}

    public CommandTrip buildWithoutEndCity(){ return new CommandTrip(seatsAvailable, seatsSold, startCity, endCity, idDriver, tripDate, ticketAmount);}

    public CommandTrip buildWithoutIdDriver(){ return new CommandTrip(seatsAvailable, seatsSold, startCity, endCity, idDriver, tripDate, ticketAmount);}

    public CommandTrip buildMinvalueSeatsAvailable(){ return new CommandTrip(minimumSeatsAvailable, seatsSold, startCity, endCity, idDriver, tripDate, ticketAmount);}

    public CommandTrip buildBadDateFormat(){ return new CommandTrip(minimumSeatsAvailable, seatsSold, startCity, endCity, idDriver, badTripDate, ticketAmount);}

}
