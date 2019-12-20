package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestServiceCreateDriver {

    @Test
    public void validateCreatedDriver(){
        Driver driver = new DriverTestDataBuilder().build();
        RepositoryDriver repositoryDriver = Mockito.mock(RepositoryDriver.class);
        Mockito.when(repositoryDriver.createDriver(Mockito.any())).thenReturn(driver);
        ServiceCreateDriver serviceCreateDriver = new ServiceCreateDriver(repositoryDriver);
        DtoDriver dtoDriver = serviceCreateDriver.run(driver);
        assertEquals(driver.getName(), dtoDriver.getName(), "Error creating user, no name");
        assertEquals(driver.getLastName(), dtoDriver.getLastName(), "Error creating user, no name");
        assertEquals(driver.getIdentification(), dtoDriver.getIdentification(), "Error creating user, no name");

    }
}
