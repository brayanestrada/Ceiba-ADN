package com.ventas.ventadepasajes.infrastructure.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_trip")
public class EntityTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double cost;
    private int seats_available;
    private int seats_sold;
    private String startCity;
    private String endCity;
    private long idDriver;

    public EntityTrip(){}

    public EntityTrip(long id, double cost, int seats_available, int seats_sold, String startCity, String endCity, long idDriver){
        this.id = id;
        this.cost = cost;
        this.seats_available = seats_available;
        this.seats_sold = seats_sold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
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

    public int getSeats_available() {
        return seats_available;
    }

    public void setSeats_available(int seats_available) {
        this.seats_available = seats_available;
    }

    public int getSeats_sold() {
        return seats_sold;
    }

    public void setSeats_sold(int seats_sold) {
        this.seats_sold = seats_sold;
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
}
