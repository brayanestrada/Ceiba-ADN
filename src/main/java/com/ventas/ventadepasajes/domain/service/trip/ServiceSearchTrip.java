package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.service.trip.mapper.MapperTrip;

public class ServiceSearchTrip {

    private RepositoryTrip repositoryTrip;

    public ServiceSearchTrip(RepositoryTrip repositoryTrip){
        this.repositoryTrip = repositoryTrip;
    }

    public DtoTrip run(long id){
        MapperTrip mapperTrip = new MapperTrip();
        return mapperTrip.entityToDto(this.repositoryTrip.searchTrip(id));

    }
}
