package com.ventas.ventadepasajes.domain.service.driver;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestServiceCreateDriver {

    @Test
    public void validateCreatedUser(){
        Driver driver = new DriverTestDataBuilder().build();
        Utils utils = new Utils();
        Driver driverSaved = utils.createDriver();
        assertEquals(driver.getName(), driverSaved.getName(), "Error creating user, no name");
        assertEquals(driver.getLastName(), driverSaved.getLastName(), "Error creating user, no name");
        assertEquals(driver.getIdentification(), driverSaved.getIdentification(), "Error creating user, no name");
    }
}
