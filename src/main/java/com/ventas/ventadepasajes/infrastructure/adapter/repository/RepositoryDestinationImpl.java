package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.model.entity.Destination;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaDestinationRepository;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDestination;
import org.modelmapper.ModelMapper;

public class ReposioryDestinationImpl implements RepositoryDestination {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaDestinationRepository jpaDestinationRepository;

    @Override
    public void createDestination(Destination destination) {

    }
}
