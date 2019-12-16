package com.ventas.ventadepasajes.domain.service.driver.mapper;

import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import com.ventas.ventadepasajes.domain.model.entity.Driver;

import java.util.List;
import java.util.stream.Collectors;

public class MapperDriver {

    public DtoDriver entityToDto(Driver entity){
        return new DtoDriver(entity.getId(), entity.getName(),entity.getLastName(), entity.getIdentification());
    }

    public List<DtoDriver> entityToDtoList(List<Driver> listDriver){
        return listDriver.stream().map(e -> DtoDriver.valueOf(e)).collect(Collectors.toList());
    }
}
