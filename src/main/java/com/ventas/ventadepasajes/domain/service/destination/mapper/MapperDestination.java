package com.ventas.ventadepasajes.domain.service.destination.mapper;

import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import com.ventas.ventadepasajes.domain.model.entity.Destination;

public class Destination {

    public DtoDestination entityToDto( destination){
        DtoDestination dto = new DtoDestination();
        dto.setId(destination.g);
    }
}
