package com.ventas.ventadepasajes.domain.model;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.testdatabuilder.PurchaseTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPurchaseModel {

    private PurchaseTestDataBuilder dataBuilder = new PurchaseTestDataBuilder();

    @Test
    public void testIdTripMandatory(){
        dataBuilder.withoutIdTrip();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Trip id is mandatory");
    }

    @Test
    public void testNumberPurchasedTicketsMandatory(){
        dataBuilder.withoutPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Number of purchased tickets is mandatory");
    }

    @Test
    public void testMaximumPurchasedTickets(){
        dataBuilder.maximumPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Max number of tickets to purchase are 15");
    }

    @Test
    public void testMinimumPurchasedTickets(){
        dataBuilder.minimumPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Min number of tickets to purchase are 0");
    }

    @Test
    public void testTripDateFormat(){
        dataBuilder.tripDateFormat();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Date hasn't the correct format, it's dd-MM-yyyy");
    }

    @Test
    public void testPurchaseDateFormat(){
        dataBuilder.purchaseDateFormat();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Error: Date hasn't the correct format, it's dd-MM-yyyy");
    }

    @Test
    public void minimalBuildIdTripMandatory(){
        dataBuilder.withoutIdTrip();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.minimalBuild(), "Error: Trip id is mandatory");
    }

    @Test
    public void minimalBuildNumberPurchasedTicketsMandatory(){
        dataBuilder.withoutPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.minimalBuild(), "Error: Number of purchased tickets is mandatory");
    }

    @Test
    public void minimalBuildMaximumPurchasedTickets(){
        dataBuilder.maximumPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.minimalBuild(), "Error: Max number of tickets to purchase are 15");
    }

    @Test
    public void minimalBuildMinimumPurchasedTickets(){
        dataBuilder.minimumPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.minimalBuild(), "Error: Min number of tickets to purchase are 0");
    }

    @Test
    public void minimalWithoutIdBuildIdTripMandatory(){
        dataBuilder.withoutIdTrip();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.minimalBuildWithoutId(), "Error: Trip id is mandatory");
    }

    @Test
    public void minimalWithoutIdBuildNumberPurchasedTicketsMandatory(){
        dataBuilder.withoutPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.minimalBuildWithoutId(), "Error: Number of purchased tickets is mandatory");
    }

    @Test
    public void minimalWithoutIdBuildMaximumPurchasedTickets(){
        dataBuilder.maximumPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.minimalBuildWithoutId(), "Error: Max number of tickets to purchase are 15");
    }

    @Test
    public void minimalWithoutIdBuildMinimumPurchasedTickets(){
        dataBuilder.minimumPurchasedTickets();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.minimalBuildWithoutId(), "Error: Min number of tickets to purchase are 0");
    }

    @Test
    public void testGetterMethods(){
        Purchase purchase = dataBuilder.build();
        assertEquals(2, purchase.getNumberPurchasedTickets());
        assertEquals(5000, purchase.getTicketAmount());
        assertEquals(0, purchase.getDiscountPercentage());
        assertEquals(25000, purchase.getTotalPurchaseAmount());
        assertEquals(1, purchase.getIdTrip());
        assertEquals("2020-01-01", purchase.getPurchaseDate());
        assertEquals("2020-01-01", purchase.getTripDate());
    }

}
