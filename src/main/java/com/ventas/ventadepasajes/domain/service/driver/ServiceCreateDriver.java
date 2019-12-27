package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;

public class ServiceCreateDriver {

    private RepositoryDriver repositoryDriver;

    public ServiceCreateDriver(RepositoryDriver repositoryDriver){this.repositoryDriver = repositoryDriver;}

    public Driver run(Driver driver){
        return this.repositoryDriver.createDriver(driver);
    }
}
