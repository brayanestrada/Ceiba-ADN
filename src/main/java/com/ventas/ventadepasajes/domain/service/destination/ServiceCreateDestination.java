package com.ventas.ventadepasajes.domain.service.destination;

import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import com.ventas.ventadepasajes.domain.model.entity.Destination;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDestination;
import com.ventas.ventadepasajes.domain.service.destination.mapper.MapperDestination;

public class ServiceCreateDestination {

    private RepositoryDestination repositoryDestination;

    public ServiceCreateDestination(RepositoryDestination repositoryDestination){ this.repositoryDestination = repositoryDestination; }

    public DtoDestination run(Destination destination) {
        MapperDestination mapper = new MapperDestination();
        return mapper.entityToDto(this.repositoryDestination.createDestination(destination));
    }
}
