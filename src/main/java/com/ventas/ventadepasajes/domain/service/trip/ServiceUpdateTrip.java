package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.service.trip.mapper.MapperTrip;

public class ServiceUpdateTrip {

    private RepositoryTrip repositoryTrip;

    public ServiceUpdateTrip(RepositoryTrip repositoryTrip) { this.repositoryTrip = repositoryTrip; }

    public DtoTrip run(long id, Trip trip){
        MapperTrip mapperTrip = new MapperTrip();
        return mapperTrip.entityToDto(this.repositoryTrip.updateTrip(id, trip));
    }
}
