package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;

public class ServiceCreateTrip {

    private RepositoryTrip repositoryTrip;

    public ServiceCreateTrip(RepositoryTrip repositoryTrip){this.repositoryTrip = repositoryTrip;}

    public Trip run(Trip trip){
        return this.repositoryTrip.createTrip(trip);
    }
}
