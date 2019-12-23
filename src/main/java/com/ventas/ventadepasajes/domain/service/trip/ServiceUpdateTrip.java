package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;

public class ServiceUpdateTrip {

    private RepositoryTrip repositoryTrip;

    public ServiceUpdateTrip(RepositoryTrip repositoryTrip) { this.repositoryTrip = repositoryTrip; }

    public Trip run(long id, Trip trip){
        return this.repositoryTrip.updateTrip(id, trip);
    }
}
