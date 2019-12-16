package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoTrip {
    private long id;
    private double cost;
    private int seats_available;
    private int seats_sold;

    public DtoTrip(){}

    public DtoTrip(Long id, double cost, int seats_available, int seats_sold){
        this.id = id;
        this.cost = cost;
        this.seats_available = seats_available;
        this.seats_sold = seats_sold;
    }

    public DtoTrip(double cost, int seats_available, int seats_sold){
        this.cost = cost;
        this.seats_available = seats_available;
        this.seats_sold = seats_sold;
    }

    public static DtoTrip valueOf(Trip trip){
        DtoTrip dto = new DtoTrip();
        dto.setId(trip.getId());
        dto.setCost(trip.getCost());
        dto.setSeats_available(trip.getSeats_available());
        dto.setSeats_sold(trip.getSeats_sold());
        return dto;
    }
}
