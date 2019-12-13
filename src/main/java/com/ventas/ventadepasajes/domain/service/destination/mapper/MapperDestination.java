package com.ventas.ventadepasajes.domain.service.destination.mapper;

import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import com.ventas.ventadepasajes.domain.model.entity.Destination;

import java.util.List;
import java.util.stream.Collectors;

public class MapperDestination {

    public DtoDestination entityToDto(Destination entity){
        return new DtoDestination(entity.getId(), entity.getName());
    }

    public Destination dtoToEntity(DtoDestination dto){
        return new Destination(dto.getId(), dto.getName());
    }

    public List<DtoDestination> entityListToDtoList(List<Destination> list){
        return list.stream().map(e -> DtoDestination.valueOf(e)).collect(Collectors.toList());
    }
}
