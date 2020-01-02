package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.testdatabuilder.PurchaseTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceCreatePurchase {

    private RepositoryPurchase repoMocked = Mockito.mock(RepositoryPurchase.class);

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
    }

    @Test
    public void createPurchaseSaturday(){
        Purchase purchase = new PurchaseTestDataBuilder().buildSaturday();
        Mockito.when(this.repoMocked.createPurchase(purchase)).thenReturn(purchase);
        Purchase purchaseSaved = this.repoMocked.createPurchase(purchase);
        assertEquals(purchase.getNumberPurchasedTickets(), purchaseSaved.getNumberPurchasedTickets());
        assertEquals(purchase.getDiscountPercentage(), purchaseSaved.getDiscountPercentage());
        assertEquals(purchase.getIdTrip(), purchaseSaved.getIdTrip());
        assertEquals(purchase.getPurchaseDate(), purchaseSaved.getPurchaseDate());
        assertEquals(purchase.getTicketAmount(), purchaseSaved.getTicketAmount());
        assertEquals(purchase.getTotalPurchaseAmount(), purchaseSaved.getTotalPurchaseAmount());
    }
}
