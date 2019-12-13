package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.model.entity.Destination;
import com.ventas.ventadepasajes.infrastructure.entity.EntityDestination;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaDestinationRepository;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryDestination;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryDestinationImpl implements RepositoryDestination {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaDestinationRepository jpaDestinationRepository;

    public RepositoryDestinationImpl(JpaDestinationRepository jpaDestinationRepository){ this.jpaDestinationRepository = jpaDestinationRepository; }

    @Override
    public Destination createDestination(Destination destination) {
        EntityDestination entityDestination = this.modelMapper.map(destination, EntityDestination.class);
        EntityDestination entityDestinationSaved = this.jpaDestinationRepository.save(entityDestination);
        return new Destination(entityDestinationSaved.getId(), entityDestinationSaved.getName());
    }

    @Override
    public List<Destination> listDestination() {
        List<EntityDestination> listEntity = this.jpaDestinationRepository.findAll();
        return listEntity.stream().map(e -> Destination.valueOf(e)).collect(Collectors.toList());
    }
}
