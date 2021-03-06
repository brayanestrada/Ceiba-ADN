package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.infrastructure.entity.EntityTrip;

import java.util.List;
import java.util.stream.Collectors;

public class MapperTrip {

    public List<Trip> entityToModelList(List<EntityTrip> entityList){
        return entityList.stream().map(MapperTrip::valueOfModel).collect(Collectors.toList());
    }

    private static Trip valueOfModel(EntityTrip entityTrip){
        return new Trip(entityTrip.getId(),
                entityTrip.getSeatsAvailable(),
                entityTrip.getSeatsSold(),
                entityTrip.getStartCity(),
                entityTrip.getEndCity(),
                entityTrip.getIdDriver(),
                entityTrip.getTripDate(),
                entityTrip.getTicketAmount()
        );
    }

    public EntityTrip modelToEntity(Trip trip){
        return new EntityTrip(trip.getId(),
                trip.getSeatsAvailable(),
                trip.getSeatsSold(),
                trip.getStartCity(),
                trip.getEndCity(),
                trip.getTripDate(),
                trip.getTicketAmount(),
                trip.getIdDriver());
    }

    public Trip entityToModel(EntityTrip entityTrip){
        return new Trip(entityTrip.getId(),
                entityTrip.getSeatsAvailable(),
                entityTrip.getSeatsSold(),
                entityTrip.getStartCity(),
                entityTrip.getEndCity(),
                entityTrip.getIdDriver(),
                entityTrip.getTripDate(),
                entityTrip.getTicketAmount()
        );
    }

}
