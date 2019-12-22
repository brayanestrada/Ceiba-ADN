package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Utils {


        @Test
        public DtoDriver createDriver() {
                Driver driver = new DriverTestDataBuilder().build();
                RepositoryDriver repositoryDriver = Mockito.mock(RepositoryDriver.class);
                Mockito.when(repositoryDriver.createDriver(Mockito.any())).thenReturn(driver);
                ServiceCreateDriver serviceCreateDriver = new ServiceCreateDriver(repositoryDriver);
                DtoDriver dtoDriver = serviceCreateDriver.run(driver);
                System.out.println(dtoDriver.getId());
                assertTrue(driver.getName().equals(dtoDriver.getName()), "Error creating user, no name");
                assertTrue(driver.getLastName().equals(dtoDriver.getLastName()), "Error creating user, no last name");
                assertTrue(driver.getIdentification().equals(dtoDriver.getIdentification()), "Error creating user, no identification");
                return dtoDriver;
        }


}