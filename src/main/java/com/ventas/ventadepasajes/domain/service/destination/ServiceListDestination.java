package com.ventas.ventadepasajes.domain.service.destination;

import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import com.ventas.ventadepasajes.domain.model.entity.Destination;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDestination;
import com.ventas.ventadepasajes.domain.service.destination.mapper.MapperDestination;

import java.util.List;

public class ServiceListDestination {

    private RepositoryDestination repositoryDestination;

    public ServiceListDestination(RepositoryDestination repositoryDestination){ this.repositoryDestination = repositoryDestination; }

    public List<DtoDestination> run() {
        MapperDestination mapper = new MapperDestination();
        List<Destination> listDestination = this.repositoryDestination.listDestination();
        return mapper.entityListToDtoList(listDestination);
    }
}
