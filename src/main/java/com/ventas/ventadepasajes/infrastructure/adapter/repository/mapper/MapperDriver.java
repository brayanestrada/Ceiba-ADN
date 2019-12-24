package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.infrastructure.entity.EntityDriver;

import java.util.List;
import java.util.stream.Collectors;

public class MapperDriver {

    public List<Driver> entityToModelList(List<EntityDriver> entityList){
        return entityList.stream().map(MapperDriver::valueOfModel).collect(Collectors.toList());
    }

    public static Driver valueOfModel(EntityDriver entity){
        return new Driver(entity.getId(), entity.getName(), entity.getLastName(), entity.getIdentification());
    }

}
