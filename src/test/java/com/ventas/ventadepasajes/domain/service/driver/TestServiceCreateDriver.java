package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceCreateDriver {

    @Test
    public void validateCreatedUser(){
        Driver driver = new DriverTestDataBuilder().build();
        RepositoryDriver repoMock = Mockito.mock(RepositoryDriver.class);
        Mockito.when(repoMock.createDriver(driver)).thenReturn(driver);
        ServiceCreateDriver serviceCreateDriver = new ServiceCreateDriver(repoMock);
        Driver driverSaved = serviceCreateDriver.run(driver);
        assertEquals(driver.getName(), driverSaved.getName());
        assertEquals(driver.getLastName(), driverSaved.getLastName());
        assertEquals(driver.getIdentification(), driverSaved.getIdentification());
    }
}
