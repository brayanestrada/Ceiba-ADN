package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;

public class ServiceUpdateDriver {
    private RepositoryDriver repositoryDriver;

    public ServiceUpdateDriver(RepositoryDriver repositoryDriver){
        this.repositoryDriver = repositoryDriver;
    }

    public Driver run(Long id, Driver driver){
        return this.repositoryDriver.updateDriver(id, driver);
    }
}
