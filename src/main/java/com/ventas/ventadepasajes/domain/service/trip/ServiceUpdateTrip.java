package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;

public class ServiceUpdateTrip {

    private RepositoryTrip repositoryTrip;
    private RepositoryDriver repositoryDriver;

    public ServiceUpdateTrip(RepositoryTrip repositoryTrip, RepositoryDriver repositoryDriver) {
        this.repositoryTrip = repositoryTrip;
        this.repositoryDriver = repositoryDriver;
    }

    public Trip run(long id, Trip trip){
        if(!driverExistsUpdateTrip(trip.getIdDriver())){
            throw new ExceptionGeneral("Error: There are no drivers with id = " + id);
        }else{
            return this.repositoryTrip.updateTrip(id, trip);
        }
    }

    private boolean driverExistsUpdateTrip(Long idDriver){
        return this.repositoryDriver.searchDriver(idDriver);
    }
}
