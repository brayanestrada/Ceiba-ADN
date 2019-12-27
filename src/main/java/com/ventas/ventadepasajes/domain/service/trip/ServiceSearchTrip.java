package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;

public class ServiceSearchTrip {

    private RepositoryTrip repositoryTrip;

    public ServiceSearchTrip(RepositoryTrip repositoryTrip){
        this.repositoryTrip = repositoryTrip;
    }

    public Trip run(long id){
        return this.repositoryTrip.searchTrip(id);
    }
}
