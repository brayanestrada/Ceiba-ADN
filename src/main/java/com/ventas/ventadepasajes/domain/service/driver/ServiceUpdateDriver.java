package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.service.driver.mapper.MapperDriver;

public class ServiceUpdateDriver {
    private RepositoryDriver repositoryDriver;

    public ServiceUpdateDriver(RepositoryDriver repositoryDriver){
        this.repositoryDriver = repositoryDriver;
    }

    public DtoDriver run(Long id, Driver driver){
        MapperDriver mapperDriver = new MapperDriver();
        return mapperDriver.entityToDto(this.repositoryDriver.updateDriver(id, driver));
    }
}
