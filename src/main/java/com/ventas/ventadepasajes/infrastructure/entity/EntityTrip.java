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
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.tripDate = tripDate;
        this.ticketAmount = ticketAmount;
        this.idDriver = idDriver;
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

}
