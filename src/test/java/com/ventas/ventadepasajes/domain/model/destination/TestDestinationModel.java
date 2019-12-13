package com.ventas.ventadepasajes.domain.model.destination;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.testdatabuilder.DestinationTestDataBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class
TestDestinationModel {

    private DestinationTestDataBuilder dataBuilder = new DestinationTestDataBuilder();

    @Test
    public void validateMandatoryName(){
        dataBuilder.withName(null);
        assertThrows(ExceptionGeneral.class,() -> dataBuilder.build(), "Name is mandatory");
    }

    @Test
    public void validateSmallName(){
        dataBuilder.smallName();
        assertThrows(ExceptionGeneral.class,() -> dataBuilder.build(), "Name must have between 3 and 30 characters");
    }

    @Test void validateLongName(){
        dataBuilder.longName();
        assertThrows(ExceptionGeneral.class,() -> dataBuilder.build(), "Name must have between 3 and 30 characters");
    }
}
