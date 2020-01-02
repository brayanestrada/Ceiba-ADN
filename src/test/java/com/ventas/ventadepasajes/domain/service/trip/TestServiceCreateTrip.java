package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.testdatabuilder.TripTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceCreateTrip {

    @Test
    public void createTrip(){
        Trip trip = new TripTestDataBuilder().build();
        RepositoryTrip repoMocked = Mockito.mock(RepositoryTrip.class);
        Mockito.when(repoMocked.createTrip(trip)).thenReturn(trip);
        Trip tripSaved = repoMocked.createTrip(trip);
        assertEquals(trip.getSeatsAvailable(), tripSaved.getSeatsAvailable());
        assertEquals(trip.getSeatsSold(), tripSaved.getSeatsSold());
        assertEquals(trip.getStartCity(), tripSaved.getStartCity());
        assertEquals(trip.getEndCity(), tripSaved.getEndCity());
        assertEquals(trip.getTicketAmount(), tripSaved.getTicketAmount());
        assertEquals(trip.getTripDate(), tripSaved.getTripDate());
        assertEquals(trip.getIdDriver(), tripSaved.getIdDriver());
    }
}
