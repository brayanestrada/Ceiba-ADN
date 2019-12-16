package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.infrastructure.entity.EntityTrip;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaTripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryTripImpl implements RepositoryTrip {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaTripRepository jpaTripRepository;

    public RepositoryTripImpl(JpaTripRepository jpaTripRepository){this.jpaTripRepository = jpaTripRepository;}


    @Override
    public Trip createTrip(Trip trip) {
        EntityTrip entityTrip = this.modelMapper.map(trip, EntityTrip.class);
        EntityTrip entityTripSaved = this.jpaTripRepository.save(entityTrip);
        return new Trip(entityTripSaved.getId(), entityTripSaved.getCost(), entityTripSaved.getSeats_available(), entityTripSaved.getSeats_sold());
    }

    @Override
    public List<Trip> listTrip() {
        List<EntityTrip> listEntity = this.jpaTripRepository.findAll();
        return listEntity.stream().map(e -> Trip.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteTrip(long id) {
        try{
            this.jpaTripRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Trip updateTrip(long id, Trip newTrip) {
        EntityTrip entityTrip = this.modelMapper.map(newTrip, EntityTrip.class);
        EntityTrip entityTripUpdated = this.jpaTripRepository.findById(id)
                .map(trip ->{
                    trip.setId(newTrip.getId());
                    trip.setCost(newTrip.getCost());
                    trip.setSeats_available(newTrip.getSeats_available());
                    trip.setSeats_sold(newTrip.getSeats_sold());
                    return jpaTripRepository.save(trip);
                }).orElseGet(()->{
                    entityTrip.setId(id);
                    entityTrip.setCost(newTrip.getCost());
                    entityTrip.setSeats_available(newTrip.getSeats_available());
                    entityTrip.setSeats_sold(newTrip.getSeats_sold());
                    return jpaTripRepository.save(entityTrip);
                });
        return new Trip(entityTripUpdated.getId(), entityTrip.getCost(), entityTrip.getSeats_available(), entityTrip.getSeats_sold());
    }
}
