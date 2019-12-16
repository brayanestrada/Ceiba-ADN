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

    public EntityTrip(){}

    public EntityTrip(long id, double cost, int seats_available, int seats_sold){
        this.id = id;
        this.cost = cost;
        this.seats_available = seats_available;
        this.seats_sold = seats_sold;
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
}
