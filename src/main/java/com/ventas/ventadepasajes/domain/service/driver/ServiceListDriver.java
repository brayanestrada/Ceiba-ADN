package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;

import java.util.List;

public class ServiceListDriver {

    private RepositoryDriver repositoryDriver;

    public ServiceListDriver(RepositoryDriver repositoryDriver){ this.repositoryDriver = repositoryDriver; }

    public List<Driver> run(){
        return this.repositoryDriver.listDriver();
    }
}
