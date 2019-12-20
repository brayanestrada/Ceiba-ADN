package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoTrip {
    private long id;
    private double cost;
    private int seatsAvailable;
    private int seatsSold;
    private String startCity;
    private String endCity;
    private String tripDate;
    private double ticketAmount;
    private long idDriver;

    public DtoTrip(){}

    public DtoTrip(Long id, double cost, int seatsAvailable, int seatsSold, String startCity, String endCity, long idDriver, String tripDate, double ticketAmount){
        this.id = id;
        this.cost = cost;
        this.seatsAvailable = seatsAvailable;
        this.seatsSold = seatsSold;
        this.startCity = startCity;
        this.endCity = endCity;
        this.idDriver = idDriver;
        this.tripDate = tripDate;
        this.ticketAmount = ticketAmount;
    }

    public static DtoTrip valueOf(Trip trip){
        DtoTrip dtoTrip = new DtoTrip();
        dtoTrip.setId(trip.getId());
        dtoTrip.setCost(trip.getCost());
        dtoTrip.setSeatsAvailable(trip.getSeatsAvailable());
        dtoTrip.setSeatsSold(trip.getSeatsSold());
        dtoTrip.setStartCity(trip.getStartCity());
        dtoTrip.setEndCity(trip.getEndCity());
        dtoTrip.setTripDate(trip.getTripDate());
        dtoTrip.setIdDriver(trip.getIdDriver());
        dtoTrip.setTicketAmount(trip.getTicketAmount());
        return dtoTrip;
    }
}
