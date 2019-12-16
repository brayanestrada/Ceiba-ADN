package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;

public class ServiceDeleteTrip {
    
    private RepositoryTrip repositoryTrip;

    public ServiceDeleteTrip(RepositoryTrip repositoryTrip){ this.repositoryTrip = repositoryTrip;}

    public boolean run(long id){return this.repositoryTrip.deleteTrip(id);}
}
