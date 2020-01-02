package com.ventas.ventadepasajes.domain.model;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDriverModel {

    private DriverTestDataBuilder dataBuilder = new DriverTestDataBuilder();

    @Test
    public void validateNameMandatory(){
        dataBuilder.withName(null);
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Name is mandatory");
    }

    @Test
    public void validateSmallName(){
        dataBuilder.smallName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Name must be between 2 and 30 characters");
    }

    @Test
    public void validateLongName(){
        dataBuilder.longName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Name must be between 2 and 30 characters");
    }

    @Test
    public void validateLastNameMandatory(){
        dataBuilder.withLastName(null);
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Last name is mandatory");
    }

    @Test
    public void validateSmallLastName(){
        dataBuilder.smallLastName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Last name must be between 2 and 30 characters");
    }

    @Test
    public void validateLongLastName(){
        dataBuilder.longLastName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Last name must be between 2 and 30 characters");
    }

    @Test
    public void validateIdentificationMandatory(){
        dataBuilder.withIdentification(null);
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Identification is mandatory");
    }

    @Test
    public void validateSmallIdentification(){
        dataBuilder.smallIdentification();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Identification must be between 8 and 11 characters");
    }

    @Test
    public void validateLongIdentification(){
        dataBuilder.longIdentification();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Identification must be between 8 and 11 characters");
    }

    @Test
    public void testSetName(){

    }
}
