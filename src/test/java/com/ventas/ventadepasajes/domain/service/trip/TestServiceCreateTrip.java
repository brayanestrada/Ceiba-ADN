package com.ventas.ventadepasajes.domain.service.trip;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.testdatabuilder.TripTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceCreateTrip {

    private RepositoryDriver repoDriverMock = Mockito.mock(RepositoryDriver.class);
    private RepositoryTrip repositoryTrip = Mockito.mock(RepositoryTrip.class);

    @Test
    public void createTrip(){
        Trip trip = new TripTestDataBuilder().build();
        RepositoryTrip repoMocked = Mockito.mock(RepositoryTrip.class);
        Mockito.when(repoMocked.createTrip(trip)).thenReturn(trip);
        ServiceCreateTrip serviceCreateTrip = new ServiceCreateTrip(repositoryTrip, repoDriverMock);
        serviceCreateTrip.run(trip);
    }
}
