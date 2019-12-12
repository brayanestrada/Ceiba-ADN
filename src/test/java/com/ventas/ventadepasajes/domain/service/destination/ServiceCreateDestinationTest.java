package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import com.ventas.ventadepasajes.domain.model.entity.Destination;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDestination;
import com.ventas.ventadepasajes.domain.service.destination.ServiceCreateDestination;
import com.ventas.ventadepasajes.domain.testdatabuilder.DestinationTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceCreateDestinationTest {

    @Test
    public void validateCreatedUser(){
        Destination destination = new DestinationTestDataBuilder().build();
        RepositoryDestination repositoryDestination = Mockito.mock(RepositoryDestination.class);
        Mockito.when(repositoryDestination.createDestination(Mockito.any())).thenReturn(destination);
        ServiceCreateDestination serviceCreateDestination = new ServiceCreateDestination(repositoryDestination);
        DtoDestination dtoDestination = serviceCreateDestination.run(destination);
        assertThrows(ExceptionGeneral.class, () -> serviceCreateDestination.run(destination), "Errpr creating destination");
        //assertTrue(destination.getName().equals(dtoDestination.getName()),"Error creating destination");
    }
}
