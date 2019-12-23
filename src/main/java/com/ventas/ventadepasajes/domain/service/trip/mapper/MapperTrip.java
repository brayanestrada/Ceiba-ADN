package com.ventas.ventadepasajes.domain.service.trip.mapper;

import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;

import java.util.List;
import java.util.stream.Collectors;

public class MapperTrip {

    public DtoTrip entityToDto(Trip entity){
        return new DtoTrip(entity.getId(), entity.getCost(), entity.getSeatsAvailable(), entity.getSeatsSold(), entity.getStartCity(), entity.getEndCity(), entity.getIdDriver(), entity.getTripDate(), entity.getTicketAmount());
    }

    public List<DtoTrip> entityListToDtoList(List<Trip> listTrip){
        return listTrip.stream().map(e -> DtoTrip.valueOf(e)).collect(Collectors.toList());
    }
}