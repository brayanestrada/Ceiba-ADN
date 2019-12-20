package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.infrastructure.entity.EntityPurchase;
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
        return new Trip(entityTripSaved.getId(), entityTripSaved.getCost(), entityTripSaved.getSeatsAvailable(), entityTripSaved.getSeatsSold(), entityTripSaved.getStartCity(), entityTripSaved.getEndCity(), entityTripSaved.getIdDriver(), entityTripSaved.getTripDate(), entityTrip.getTicketAmount());
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
                    trip.setSeatsAvailable(newTrip.getSeatsAvailable());
                    trip.setSeatsSold(newTrip.getSeatsSold());
                    trip.setStartCity(newTrip.getStartCity());
                    trip.setEndCity(newTrip.getEndCity());
                    trip.setIdDriver(newTrip.getIdDriver());
                    return jpaTripRepository.save(trip);
                }).orElseGet(()->{
                    entityTrip.setId(id);
                    entityTrip.setCost(newTrip.getCost());
                    entityTrip.setSeatsAvailable(newTrip.getSeatsAvailable());
                    entityTrip.setSeatsSold(newTrip.getSeatsSold());
                    entityTrip.setStartCity(newTrip.getStartCity());
                    entityTrip.setEndCity(newTrip.getEndCity());
                    entityTrip.setIdDriver(newTrip.getIdDriver());
                    return jpaTripRepository.save(entityTrip);
                });
        return new Trip(entityTripUpdated.getId(), entityTrip.getCost(), entityTrip.getSeatsAvailable(), entityTrip.getSeatsSold(), entityTripUpdated.getStartCity(), entityTrip.getEndCity(), entityTrip.getIdDriver(), entityTrip.getTripDate(), entityTrip.getTicketAmount());
    }

    @Override
    public Trip searchTrip(long id){
        EntityTrip entityTrip = this.jpaTripRepository.searchTrip(id);
        try{
            return this.modelMapper.map(entityTrip, Trip.class);
        }catch (Exception e){
            throw new ExceptionGeneral("There are not trips with id " + id);
        }
    }
}
