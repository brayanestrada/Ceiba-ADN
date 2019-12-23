package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.infrastructure.entity.EntityDriver;

import java.util.List;
import java.util.stream.Collectors;

public class MapperDriver {

    public List<Driver> entityToModelList(List<EntityDriver> entityList){
        return entityList.stream().map(e -> valueOfModel(e)).collect(Collectors.toList());
    }

    public static Driver valueOfModel(EntityDriver entity){
        Driver driver = new Driver();
        driver.setId(entity.getId());
        driver.setName(entity.getName());
        driver.setLastName(entity.getLastName());
        driver.setIdentification(entity.getIdentification());
        return driver;
    }

}
