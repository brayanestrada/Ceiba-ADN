package com.ventas.ventadepasajes.aplication.command.handler.command;

public class CommandTrip {

    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private String tripDate;
    private long idDriver;
    private double ticketAmount;

    public CommandTrip(int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        this.seatsSold = seatsSold;
        this.endCity = endCity;
        this.startCity = startCity;
        this.tripDate = tripDate;
        this.seatsAvailable = seatsAvailable;
        this.ticketAmount = ticketAmount;
        this.idDriver = idDriver;
    }

    public int getSeatsAvailableCommand() {
        return seatsAvailable;
    }

    public int getSeatsSoldCommand() {
        return seatsSold;
    }

    public long getIdDriverCommand() {
        return idDriver;
    }

    public String getStartCityCommand() {
        return startCity;
    }

    public String getTripDateCommand() {
        return tripDate;
    }

    public String getEndCityCommand() {
        return endCity;
    }

    public double getTicketAmountCommand() {
        return ticketAmount;
    }

}
