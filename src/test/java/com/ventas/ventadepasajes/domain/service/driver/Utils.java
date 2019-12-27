package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.testdatabuilder.DriverTestDataBuilder;
import org.mockito.Mockito;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class Utils {

        public Driver createDriver() {
                Driver driver = new DriverTestDataBuilder().build();
                RepositoryDriver repositoryDriver = Mockito.mock(RepositoryDriver.class);
                Mockito.when(repositoryDriver.createDriver(Mockito.any())).thenReturn(driver);
                ServiceCreateDriver serviceCreateDriver = new ServiceCreateDriver(repositoryDriver);
                Driver driverSaved = serviceCreateDriver.run(driver);
                System.out.println(driverSaved.getId());
                assertEquals(driver.getName(), driverSaved.getName(), "Error creating user, no name");
                assertEquals(driver.getLastName(), driverSaved.getLastName(), "Error creating user, no last name");
                assertEquals(driver.getIdentification(), driverSaved.getIdentification(), "Error creating user, no identification");
                return driverSaved;
        }
}