package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.service.driver.ServiceCreateDriver;
import com.ventas.ventadepasajes.domain.service.trip.ServiceCreateTrip;
import com.ventas.ventadepasajes.domain.testdatabuilder.DriverTestDataBuilder;
import com.ventas.ventadepasajes.domain.testdatabuilder.PurchaseTestDataBuilder;
import com.ventas.ventadepasajes.domain.testdatabuilder.TripTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceCreatePurchase {

    private RepositoryPurchase repoMocked = Mockito.mock(RepositoryPurchase.class);
    private RepositoryTrip repoTripMocked = Mockito.mock(RepositoryTrip.class);
    private RepositoryDriver repoDriverMocked = Mockito.mock(RepositoryDriver.class);

    @Test
    public void createPurchase(){
        Purchase purchase = new PurchaseTestDataBuilder().build();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Purchase purchaseSaved = this.repoMocked.createPurchase(purchase);
        assertEquals(purchase.getNumberPurchasedTickets(), purchaseSaved.getNumberPurchasedTickets());
        assertEquals(purchase.getDiscountPercentage(), purchaseSaved.getDiscountPercentage());
        assertEquals(purchase.getIdTrip(), purchaseSaved.getIdTrip());
        assertEquals(purchase.getPurchaseDate(), purchaseSaved.getPurchaseDate());
        assertEquals(purchase.getTicketAmount(), purchaseSaved.getTicketAmount());
        assertEquals(purchase.getTotalPurchaseAmount(), purchaseSaved.getTotalPurchaseAmount());
    }

    @Test
    public void createPurchasePurchasedTickets(){
        Purchase purchase = new PurchaseTestDataBuilder().buildMoreThanFourTickets();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Purchase purchaseSaved = this.repoMocked.createPurchase(purchase);
        assertEquals(purchase.getNumberPurchasedTickets(), purchaseSaved.getNumberPurchasedTickets());
        assertEquals(purchase.getDiscountPercentage(), purchaseSaved.getDiscountPercentage());
        assertEquals(purchase.getIdTrip(), purchaseSaved.getIdTrip());
        assertEquals(purchase.getPurchaseDate(), purchaseSaved.getPurchaseDate());
        assertEquals(purchase.getTicketAmount(), purchaseSaved.getTicketAmount());
        assertEquals(purchase.getTotalPurchaseAmount(), purchaseSaved.getTotalPurchaseAmount());
        assertEquals(10, purchaseSaved.getDiscountPercentage());
    }

    @Test
    public void createPurchaseSaturdayAndThreeTickets(){
        Purchase purchase = new PurchaseTestDataBuilder().buildSaturday();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Purchase purchaseSaved = this.repoMocked.createPurchase(purchase);
        assertEquals(purchase.getNumberPurchasedTickets(), purchaseSaved.getNumberPurchasedTickets());
        assertEquals(purchase.getDiscountPercentage(), purchaseSaved.getDiscountPercentage());
        assertEquals(purchase.getIdTrip(), purchaseSaved.getIdTrip());
        assertEquals(purchase.getPurchaseDate(), purchaseSaved.getPurchaseDate());
        assertEquals(purchase.getTicketAmount(), purchaseSaved.getTicketAmount());
        assertEquals(purchase.getTotalPurchaseAmount(), purchaseSaved.getTotalPurchaseAmount());
        assertEquals(0, purchaseSaved.getDiscountPercentage());
    }

    @Test
    public void createPurchaseSaturdayAndMoreThanFourTickets() throws ParseException {
        Purchase purchase = new PurchaseTestDataBuilder().buildWednesdayAndMoreThan4Tickets();
        Trip trip = new TripTestDataBuilder().build();
        Driver driver = new DriverTestDataBuilder().build();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Mockito.when(this.repoTripMocked.createTrip(trip)).thenReturn(trip);
        Mockito.when(this.repoDriverMocked.createDriver(driver)).thenReturn(driver);
        ServiceCreateDriver serviceCreateDriver = new ServiceCreateDriver(repoDriverMocked);
        Driver driverSaved = serviceCreateDriver.run(driver);
        ServiceCreateTrip serviceCreateTrip = new ServiceCreateTrip(repoTripMocked, repoDriverMocked);
        Trip tripSaved = serviceCreateTrip.run(trip);
        ServiceCreatePurchase serviceCreatePurchase = new ServiceCreatePurchase(repoMocked, repoTripMocked);
        Purchase purchaseSaved = serviceCreatePurchase.run(purchase);
        assertEquals(purchase.getNumberPurchasedTickets(), purchaseSaved.getNumberPurchasedTickets());
        assertEquals(purchase.getDiscountPercentage(), purchaseSaved.getDiscountPercentage());
        assertEquals(purchase.getIdTrip(), purchaseSaved.getIdTrip());
        assertEquals(purchase.getPurchaseDate(), purchaseSaved.getPurchaseDate());
        assertEquals(purchase.getTicketAmount(), purchaseSaved.getTicketAmount());
        assertEquals(purchase.getTotalPurchaseAmount(), purchaseSaved.getTotalPurchaseAmount());
        assertEquals(20, purchaseSaved.getDiscountPercentage());
    }
}
