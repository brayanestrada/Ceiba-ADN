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


        /*

        Mockito.when(mockRepoDriver.listDriver()).thenReturn(list);
        ServiceCreateDriver serviceCreateDriver = new ServiceCreateDriver(mockRepoDriver);

        Driver driver1 = serviceCreateDriver.run(driver);
        list = serviceListDriver.run();
        System.out.println(list.get(0).getName());*/



/*
        Mockito.when(repoTripMock.createTrip(trip)).then((Answer<?>) repoDriverMock.createDriver(driver)).thenReturn(trip);
        ServiceCreateDriver serviceCreateDriver1 = new ServiceCreateDriver(repoDriverMock);
        //driver1 = serviceCreateDriver.run(driver);
        System.out.println(driver1.getName());
        Mockito.when(repoTripMock.createTrip(trip)).thenReturn(trip);
        ServiceCreateTrip serviceCreateTrip = new ServiceCreateTrip(repoTripMock, repoDriverMock);
        tripSaved = serviceCreateTrip.run(trip);
        System.out.println(tripSaved.getId());
        System.out.println(tripSaved.getStartCity());*/
    }
}
