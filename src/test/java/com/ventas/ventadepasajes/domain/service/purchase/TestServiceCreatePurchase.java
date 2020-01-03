package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.testdatabuilder.PurchaseTestDataBuilder;
import com.ventas.ventadepasajes.domain.testdatabuilder.TripTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceCreatePurchase {

    private RepositoryPurchase repoMocked = Mockito.mock(RepositoryPurchase.class);
    private RepositoryTrip repoTripMocked = Mockito.mock(RepositoryTrip.class);

    @Test
    public void createPurchaseMonday4Tickets() throws ParseException {
        Purchase purchase = new PurchaseTestDataBuilder().buildMonday4Tickets();
        Trip trip = new TripTestDataBuilder().buildMonday();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Mockito.when(this.repoTripMocked.searchTrip(purchase.getIdTrip())).thenReturn(trip);
        ServiceCreatePurchase serviceCreatePurchase = new ServiceCreatePurchase(this.repoMocked, this.repoTripMocked);
        Purchase purchaseSaved = serviceCreatePurchase.run(purchase);
        assertEquals(20, purchaseSaved.getDiscountPercentage());
    }

    @Test
    public void createPurchaseThursday4Tickets() throws ParseException {
        Purchase purchase = new PurchaseTestDataBuilder().buildThursday4Tickets();
        Trip trip = new TripTestDataBuilder().buildThursday();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Mockito.when(this.repoTripMocked.searchTrip(purchase.getIdTrip())).thenReturn(trip);
        ServiceCreatePurchase serviceCreatePurchase = new ServiceCreatePurchase(this.repoMocked, this.repoTripMocked);
        Purchase purchaseSaved = serviceCreatePurchase.run(purchase);
        assertEquals(20, purchaseSaved.getDiscountPercentage());
    }

    @Test
    public void createPurchaseFriday4Tickets() throws ParseException {
        Purchase purchase = new PurchaseTestDataBuilder().buildFriday4Tickets();
        Trip trip = new TripTestDataBuilder().buildFriday();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Mockito.when(this.repoTripMocked.searchTrip(purchase.getIdTrip())).thenReturn(trip);
        ServiceCreatePurchase serviceCreatePurchase = new ServiceCreatePurchase(this.repoMocked, this.repoTripMocked);
        Purchase purchaseSaved = serviceCreatePurchase.run(purchase);
        assertEquals(10, purchaseSaved.getDiscountPercentage());
    }

    @Test
    public void createPurchaseMonday3Tickets() throws ParseException {
        Purchase purchase = new PurchaseTestDataBuilder().buildMonday3Tickets();
        Trip trip = new TripTestDataBuilder().buildMonday();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Mockito.when(this.repoTripMocked.searchTrip(purchase.getIdTrip())).thenReturn(trip);
        ServiceCreatePurchase serviceCreatePurchase = new ServiceCreatePurchase(this.repoMocked, this.repoTripMocked);
        Purchase purchaseSaved = serviceCreatePurchase.run(purchase);
        assertEquals(10, purchaseSaved.getDiscountPercentage());
    }

    @Test
    public void createPurchaseThursday3Tickets() throws ParseException {
        Purchase purchase = new PurchaseTestDataBuilder().buildThursday3Tickets();
        Trip trip = new TripTestDataBuilder().buildThursday();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Mockito.when(this.repoTripMocked.searchTrip(purchase.getIdTrip())).thenReturn(trip);
        ServiceCreatePurchase serviceCreatePurchase = new ServiceCreatePurchase(this.repoMocked, this.repoTripMocked);
        Purchase purchaseSaved = serviceCreatePurchase.run(purchase);
        assertEquals(10, purchaseSaved.getDiscountPercentage());
    }

    @Test
    public void createPurchaseFriday3Tickets() throws ParseException {
        Purchase purchase = new PurchaseTestDataBuilder().buildFriday3Tickets();
        Trip trip = new TripTestDataBuilder().buildFriday();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Mockito.when(this.repoTripMocked.searchTrip(purchase.getIdTrip())).thenReturn(trip);
        ServiceCreatePurchase serviceCreatePurchase = new ServiceCreatePurchase(this.repoMocked, this.repoTripMocked);
        Purchase purchaseSaved = serviceCreatePurchase.run(purchase);
        assertEquals(0, purchaseSaved.getDiscountPercentage());
    }

}
