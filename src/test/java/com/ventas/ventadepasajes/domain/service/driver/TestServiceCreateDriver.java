package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestServiceCreateDriver {

    @Test
    public void validateCreatedUser(){
        Driver driver = new DriverTestDataBuilder().build();
        Utils utils = new Utils();
        DtoDriver dtoDriver = utils.createDriver();
        assertEquals(driver.getName(), dtoDriver.getName(), "Error creating user, no name");
        assertEquals(driver.getLastName(), dtoDriver.getLastName(), "Error creating user, no name");
        assertEquals(driver.getIdentification(), dtoDriver.getIdentification(), "Error creating user, no name");
    }

    @Test
    public void updateUser(){
        Driver driver = new DriverTestDataBuilder().build();
        RepositoryDriver repositoryDriver = Mockito.mock(RepositoryDriver.class);
        Mockito.when(repositoryDriver.createDriver(Mockito.any())).thenReturn(driver);
        ServiceCreateDriver serviceCreateDriver = new ServiceCreateDriver(repositoryDriver);
        DtoDriver dtoDriver = serviceCreateDriver.run(driver);
        Driver driverUpdated = new DriverTestDataBuilder().build();
        driverUpdated.setName("Juan");
        driverUpdated.setLastName("Sepulveda");
        driverUpdated.setIdentification("1234567891");
        Mockito.when(repositoryDriver.updateDriver(dtoDriver.getId(),  driverUpdated)).thenReturn(driver);
        ServiceUpdateDriver serviceUpdateDriver = new ServiceUpdateDriver(repositoryDriver);
        DtoDriver dtoDriverUpdated = serviceUpdateDriver.run((long)1, driver);
        assertNotEquals(dtoDriver.getName(), dtoDriverUpdated.getName(), "Error updating driver, names match");
        assertNotEquals(dtoDriver.getLastName(), dtoDriverUpdated.getLastName(), "Error updating driver, last names match");
        assertNotEquals(dtoDriver.getIdentification(), dtoDriverUpdated.getIdentification(), "Error updating driver, identifications match");
    }
}
