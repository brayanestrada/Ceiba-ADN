package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.infrastructure.entity.EntityDriver;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaDriverRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryDriverImpl implements RepositoryDriver {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaDriverRepository jpaDriverRepository;

    public RepositoryDriverImpl(JpaDriverRepository jpaDriverRepository){this.jpaDriverRepository = jpaDriverRepository;}

    @Override
    public Driver createDriver(Driver driver) {
        EntityDriver entityDriver = this.modelMapper.map(driver, EntityDriver.class);
        EntityDriver entityDriverSaved = this.jpaDriverRepository.save(entityDriver);
        return new Driver(entityDriverSaved.getId(), entityDriverSaved.getName(), entityDriverSaved.getLastName(), entityDriverSaved.getIdentification());
    }

    @Override
    public List<Driver> listDriver() {
        List<EntityDriver> listEntity = this.jpaDriverRepository.findAll();
        return listEntity.stream().map(e->Driver.valueOf(e)).collect(Collectors.toList());
    }
}
