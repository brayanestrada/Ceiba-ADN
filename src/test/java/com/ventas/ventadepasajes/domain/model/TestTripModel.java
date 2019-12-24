package com.ventas.ventadepasajes.domain.model;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.testdatabuilder.TripTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTripModel {

    private TripTestDataBuilder dataBuilder =  new TripTestDataBuilder();

    @Test
    public void testSeatsAvailableMandatory(){
        dataBuilder.withoutSeatsAvailable();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Seats available value is mandatory");
    }

    @Test
    public void testSeatsSoldMandatory(){
        dataBuilder.withoutSeatsSold();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Seats sold value is mandatory");
    }

    @Test
    public void testStartCityMandatory(){
        dataBuilder.withoutStartCity();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Start city is mandatory");
    }

    @Test
    public void testEndCityMandatory(){
        dataBuilder.withoutEndCity();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: End city is mandatory");
    }

    @Test
    public void testIdDriverMandatory(){
        dataBuilder.withoutIdDriver();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Driver id is mandatory");
    }

    @Test
    public void testMinimumSeatsAvailable(){
        dataBuilder.validateMinimumValueSeatsAvailable();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "The minimum available seats are 0");
    }

    @Test
    public void testTripDateFormat(){
        dataBuilder.validateTripDateFormat();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Date format is not correct, it must be dd-MM-yyyy");
    }
    @Test
    public void testSeatsAvailableMandatoryWithoutId(){
        dataBuilder.withoutSeatsAvailable();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.buildWithoutId(), "Error: Seats available value is mandatory");
    }

    @Test
    public void testSeatsSoldMandatoryWithoutId(){
        dataBuilder.withoutSeatsSold();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.buildWithoutId(), "Error: Seats sold value is mandatory");
    }

    @Test
    public void testStartCityMandatoryWithoutId(){
        dataBuilder.withoutStartCity();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.buildWithoutId(), "Error: Start city is mandatory");
    }

    @Test
    public void testEndCityMandatoryWithoutId(){
        dataBuilder.withoutEndCity();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.buildWithoutId(), "Error: End city is mandatory");
    }

    @Test
    public void testIdDriverMandatoryWithoutId(){
        dataBuilder.withoutIdDriver();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.buildWithoutId(), "Error: Driver id is mandatory");
    }

    @Test
    public void testMinimumSeatsAvailableWithoutId(){
        dataBuilder.validateMinimumValueSeatsAvailable();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.buildWithoutId(), "The minimum available seats are 0");
    }

    @Test
    public void testTripDateFormatWithoutId(){
        dataBuilder.validateTripDateFormat();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.buildWithoutId(), "Error: Date format is not correct, it must be dd-MM-yyyy");
    }
}
