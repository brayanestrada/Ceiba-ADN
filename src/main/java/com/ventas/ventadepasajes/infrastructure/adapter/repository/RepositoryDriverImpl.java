package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper.MapperDriver;
import com.ventas.ventadepasajes.infrastructure.entity.EntityDriver;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaDriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryDriverImpl implements RepositoryDriver {

    private JpaDriverRepository jpaDriverRepository;
    private static final Logger logger = LoggerFactory.getLogger(RepositoryDriverImpl.class);
    private MapperDriver mapperDriver = new MapperDriver();

    public RepositoryDriverImpl(JpaDriverRepository jpaDriverRepository){this.jpaDriverRepository = jpaDriverRepository;}

    @Override
    public Driver createDriver(Driver driver) {
        EntityDriver entityDriver = this.mapperDriver.modelToEntity(driver);
        EntityDriver entityDriverSaved = this.jpaDriverRepository.save(entityDriver);
        return new Driver(entityDriverSaved.getIdEntity(), entityDriverSaved.getNameEntity(), entityDriverSaved.getLastNameEntity(), entityDriverSaved.getIdentificationEntity());
    }

    @Override
    public List<Driver> listDriver() {
        List<EntityDriver> entityDriver = this.jpaDriverRepository.findAll();
        return this.mapperDriver.entityToModelList(entityDriver);
    }

    @Override
    public boolean deleteDriver(Long id) {
        try{
            this.jpaDriverRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Error deleting driver");
            return false;
        }
    }

    @Override
    public Driver updateDriver(Long id, Driver newDriver) {
        EntityDriver entityDriverUpdated =  jpaDriverRepository.findById(id)
                .map(driver ->{
                    driver.setNameEntity(newDriver.getName());
                    driver.setLastNameEntity(newDriver.getLastName());
                    driver.setIdentificationEntity(newDriver.getIdentification());
                    return jpaDriverRepository.save(driver);
                })
                .orElseGet(()->{
                    EntityDriver entityDriver = new EntityDriver(id, newDriver.getName(), newDriver.getLastName(),newDriver.getIdentification());
                    return jpaDriverRepository.save(entityDriver);
                });
        return new Driver(entityDriverUpdated.getIdEntity(), entityDriverUpdated.getNameEntity(), entityDriverUpdated.getLastNameEntity(), entityDriverUpdated.getIdentificationEntity());
    }

    @Override
    public boolean searchDriver(Long id) {
        Optional<EntityDriver> entityDriver = this.jpaDriverRepository.searchDriver(id);
        if(!entityDriver.isPresent()){
            throw new ExceptionGeneral("Error: There are no drivers with id = " + id);
        }else{
            return true;
        }
    }


}
