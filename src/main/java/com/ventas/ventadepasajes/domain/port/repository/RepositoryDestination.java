package com.ventas.ventadepasajes.infrastructure.port.repository;

import com.ventas.ventadepasajes.domain.model.Destination;

public interface RepositoryDestination {
    void createDestination(Destination destination);
}
