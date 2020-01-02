package com.ventas.ventadepasajes.infrastructure.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_trip")
public class EntityTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private String tripDate;
    private double ticketAmount;
    private long idDriver;

    private EntityTrip(){}

    public EntityTrip(long id,
                      int seatsAvailable,
                      int seatsSold,
                      String startCity,
                      String endCity,
                      String tripDate,
                      double ticketAmount,
                      long idDriver){
        this.id = id;
        this.seatsSold = seatsSold;
        this.ticketAmount = ticketAmount;
        this.seatsAvailable = seatsAvailable;
        this.startCity = startCity;
        this.idDriver = idDriver;
        this.tripDate = tripDate;
        this.endCity = endCity;
    }

    public long getIdEntity() {
        return id;
    }

    public void setIdEntity(long id) {
        this.id = id;
    }

    public int getSeatsAvailableEntity() {
        return seatsAvailable;
    }

    public void setSeatsAvailableEntity(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public int getSeatsSoldEntity() {
        return seatsSold;
    }

    public void setSeatsSoldEntity(int seatsSold) {
        this.seatsSold = seatsSold;
    }

    public String getStartCityEntity() {
        return startCity;
    }

    public void setStartCityEntity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCityEntity() {
        return endCity;
    }

    public void setEndCityEntity(String endCity) {
        this.endCity = endCity;
    }

    public long getIdDriverEntity() {
        return idDriver;
    }

    public void setIdDriverEntity(long idDriver) {
        this.idDriver = idDriver;
    }

    public String getTripDateEntity() {
        return tripDate;
    }

    public void setTripDateEntity(String tripDate) {
        this.tripDate = tripDate;
    }

    public double getTicketAmountEntity() {
        return ticketAmount;
    }

    public void setTicketAmountEntity(double ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

}
