package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoTrip {
    private long id;
    private double cost;
    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private long idDriver;

    public DtoTrip(){}

    public DtoTrip(Long id, double cost, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver){
        this.id = id;
        this.cost = cost;
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
    }

    public DtoTrip(double cost, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver){
        this.cost = cost;
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
    }

    public static DtoTrip valueOf(Trip trip){
        DtoTrip dtoTrip = new DtoTrip();
        dtoTrip.setId(trip.getId());
        dtoTrip.setCost(trip.getCost());
        dtoTrip.setSeatsAvailable(trip.getSeats_available());
        dtoTrip.setSeatsSold(trip.getSeats_sold());
        dtoTrip.setStartCity(trip.getStartCity());
        dtoTrip.setEndCity(trip.getEndCity());
        dtoTrip.setIdDriver(trip.getIdDriver());
        return dtoTrip;
    }
}
