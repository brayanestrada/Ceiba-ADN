package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.Destination;

import java.util.List;

public interface RepositoryDestination {
    Destination createDestination(Destination destination);

    List<Destination> listDestination();
}
