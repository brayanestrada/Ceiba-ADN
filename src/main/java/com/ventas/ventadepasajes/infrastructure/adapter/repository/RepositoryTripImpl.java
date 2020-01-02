package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper.MapperTrip;
import com.ventas.ventadepasajes.infrastructure.entity.EntityTrip;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaTripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryTripImpl implements RepositoryTrip {

    private JpaTripRepository jpaTripRepository;
    private Logger logger = LoggerFactory.getLogger(RepositoryTripImpl.class);
    private MapperTrip mapperTrip = new MapperTrip();

    public RepositoryTripImpl(JpaTripRepository jpaTripRepository){this.jpaTripRepository = jpaTripRepository;}

    @Override
    public Trip createTrip(Trip trip) {
        EntityTrip entityTrip = this.mapperTrip.modelToEntity(trip);
        EntityTrip entityTripSaved = this.jpaTripRepository.save(entityTrip);
        return new Trip(entityTripSaved.getIdEntity(), entityTripSaved.getSeatsAvailableEntity(), entityTripSaved.getSeatsSoldEntity(), entityTripSaved.getStartCityEntity(), entityTripSaved.getEndCityEntity(), entityTripSaved.getIdDriverEntity(), entityTripSaved.getTripDateEntity(), entityTrip.getTicketAmountEntity());
    }

    @Override
    public List<Trip> listTrip() {
        return this.mapperTrip.entityToModelList(this.jpaTripRepository.findAll());
    }

    @Override
    public boolean deleteTrip(long id) {

        try{
            this.jpaTripRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.info("Error deleting trip");
            return false;
        }
    }

    @Override
    public Trip updateTrip(long id, Trip newTrip) {
        EntityTrip entityTrip = this.mapperTrip.modelToEntity(newTrip);
        EntityTrip entityTripUpdated = this.jpaTripRepository.findById(id)
                .map(trip ->{
                    trip.setIdEntity(newTrip.getId());
                    trip.setSeatsAvailableEntity(newTrip.getSeatsAvailable());
                    trip.setSeatsSoldEntity(newTrip.getSeatsSold());
                    trip.setStartCityEntity(newTrip.getStartCity());
                    trip.setEndCityEntity(newTrip.getEndCity());
                    trip.setTicketAmountEntity(newTrip.getTicketAmount());
                    trip.setIdDriverEntity(newTrip.getIdDriver());
                    return jpaTripRepository.save(trip);
                }).orElseGet(()->{
                    entityTrip.setIdEntity(id);
                    entityTrip.setSeatsAvailableEntity(newTrip.getSeatsAvailable());
                    entityTrip.setSeatsSoldEntity(newTrip.getSeatsSold());
                    entityTrip.setStartCityEntity(newTrip.getStartCity());
                    entityTrip.setEndCityEntity(newTrip.getEndCity());
                    entityTrip.setIdDriverEntity(newTrip.getIdDriver());
                    entityTrip.setTicketAmountEntity(newTrip.getTicketAmount());
                    return jpaTripRepository.save(entityTrip);
                });
        return new Trip(entityTripUpdated.getIdEntity(), entityTrip.getSeatsAvailableEntity(), entityTrip.getSeatsSoldEntity(), entityTripUpdated.getStartCityEntity(), entityTrip.getEndCityEntity(), entityTrip.getIdDriverEntity(), entityTrip.getTripDateEntity(), entityTrip.getTicketAmountEntity());
    }

    @Override
    public Trip searchTrip(long id){
        try{
            return this.mapperTrip.entityToModel(this.jpaTripRepository.searchTrip(id));
        }catch (Exception e){
            throw new ExceptionGeneral("There are not trips with id " + id);
        }
    }
}
