package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.service.trip.mapper.MapperTrip;

public class ServiceCreateTrip {

    private RepositoryTrip repositoryTrip;

    public ServiceCreateTrip(RepositoryTrip repositoryTrip){this.repositoryTrip = repositoryTrip;}

    public DtoTrip run(Trip trip){
        MapperTrip mapperTrip = new MapperTrip();
        return mapperTrip.entityToDto(this.repositoryTrip.createTrip(trip));
    }
}
