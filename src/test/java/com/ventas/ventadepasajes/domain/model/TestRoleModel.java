package com.ventas.ventadepasajes.domain.model;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.testdatabuilder.RoleTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRoleModel {

    private RoleTestDataBuilder dataBuilder = new RoleTestDataBuilder();

    @Test
    public void testNameMandatory(){
        dataBuilder.withoutName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Name is mandatory");
    }

    @Test
    public void testShortName(){
        dataBuilder.shortName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Name characters must be between 2 and 35 characters");
    }

    @Test
    public void testLongName(){
        dataBuilder.longName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Name characters must be between 2 and 35 characters");
    }

    @Test
    public void testNameWithIdMandatory(){
        dataBuilder.withoutName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Name is mandatory");
    }

    @Test
    public void testWithIdShortName(){
        dataBuilder.shortName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Name characters must be between 2 and 35 characters");
    }

    @Test
    public void testWithIdLongName(){
        dataBuilder.longName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Name characters must be between 2 and 35 characters");
    }


}
