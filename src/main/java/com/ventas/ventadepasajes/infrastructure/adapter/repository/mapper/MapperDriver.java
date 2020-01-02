package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.infrastructure.entity.EntityDriver;

import java.util.List;
import java.util.stream.Collectors;

public class MapperDriver {

    public List<Driver> entityToModelList(List<EntityDriver> entityList){
        return entityList.stream().map(MapperDriver::valueOfModel).collect(Collectors.toList());
    }

    private static Driver valueOfModel(EntityDriver entity){
        return new Driver(entity.getIdEntity(), entity.getNameEntity(), entity.getLastNameEntity(), entity.getIdentificationEntity());
    }

    public EntityDriver modelToEntity(Driver driver){
        return new EntityDriver(driver.getId(), driver.getName(), driver.getLastName(), driver.getIdentification());
    }

}
