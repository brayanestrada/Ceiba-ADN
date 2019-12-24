package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.infrastructure.entity.EntityTrip;

import java.util.List;
import java.util.stream.Collectors;

public class MapperTrip {

    public List<Trip> entityToModelList(List<EntityTrip> entityList){
        return entityList.stream().map(MapperTrip::valueOfModel).collect(Collectors.toList());
    }

    public static Trip valueOfModel(EntityTrip entityTrip){
        Trip trip = new Trip();
        trip.setId(entityTrip.getId());
        trip.setStartCity(entityTrip.getStartCity());
        trip.setIdDriver(entityTrip.getIdDriver());
        trip.setEndCity(entityTrip.getEndCity());
        trip.setSeatsAvailable(entityTrip.getSeatsAvailable());
        trip.setTicketAmount(entityTrip.getTicketAmount());
        trip.setSeatsSold(entityTrip.getSeatsSold());
        trip.setTripDate(entityTrip.getTripDate());
        return trip;
    }
}
