package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.service.trip.mapper.MapperTrip;

import java.util.List;

public class ServiceListTrip {

    private RepositoryTrip repositoryTrip;

    public ServiceListTrip(RepositoryTrip repositoryTrip){this.repositoryTrip = repositoryTrip;}

    public List<DtoTrip> run(){
        MapperTrip mapperTrip = new MapperTrip();
        List<Trip> listTrip = this.repositoryTrip.listTrip();
        return mapperTrip.entityListToDtoList(listTrip);
    }
}
