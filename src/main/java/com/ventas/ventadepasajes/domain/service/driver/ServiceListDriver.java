package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.service.driver.mapper.MapperDriver;

import java.util.List;

public class ServiceListDriver {

    private RepositoryDriver repositoryDriver;

    public ServiceListDriver(RepositoryDriver repositoryDriver){ this.repositoryDriver = repositoryDriver; }

    public List<DtoDriver> run(){
        MapperDriver mapperDriver = new MapperDriver();
        List<Driver> listDriver = this.repositoryDriver.listDriver();
        return mapperDriver.entityToDtoList(listDriver);
    }
}
