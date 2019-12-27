package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;

import java.util.List;

public class ServiceListTrip {

    private RepositoryTrip repositoryTrip;

    public ServiceListTrip(RepositoryTrip repositoryTrip){this.repositoryTrip = repositoryTrip;}

    public List<Trip> run(){
        return this.repositoryTrip.listTrip();
    }
}
