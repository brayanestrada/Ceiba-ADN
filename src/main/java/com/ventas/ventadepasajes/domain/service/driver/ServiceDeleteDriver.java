package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;

public class ServiceDeleteDriver {

    private RepositoryDriver repositoryDriver;

    public ServiceDeleteDriver (RepositoryDriver repositoryDriver){this.repositoryDriver = repositoryDriver;}

    public boolean run(Long id){
        return this.repositoryDriver.deleteDriver(id);
    }
}
