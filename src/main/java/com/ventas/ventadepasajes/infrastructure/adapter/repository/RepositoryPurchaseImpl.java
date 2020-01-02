package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper.MapperPurchase;
import com.ventas.ventadepasajes.infrastructure.entity.EntityPurchase;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaPurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryPurchaseImpl implements RepositoryPurchase {

    private JpaPurchaseRepository jpaPurchaseRepository;
    private MapperPurchase mapperPurchase = new MapperPurchase();
    private Logger logger = LoggerFactory.getLogger(RepositoryPurchaseImpl.class);

    public RepositoryPurchaseImpl(JpaPurchaseRepository jpaPurchaseRepository){this.jpaPurchaseRepository = jpaPurchaseRepository;}

    @Override
    public Purchase createPurchase(Purchase purchase) {
        EntityPurchase entityPurchase = this.mapperPurchase.modelToEntity(purchase);
        EntityPurchase entityPurchaseSaved = this.jpaPurchaseRepository.save(entityPurchase);
        return new Purchase(entityPurchaseSaved.getIdEntity(), entityPurchase.getNumberPurchasedTicketsEntity(), entityPurchase.getTicketAmountEntity(), purchase.getDiscountPercentage(), purchase.getTotalPurchaseAmount(), purchase.getIdTrip(), purchase.getPurchaseDate(), purchase.getTripDate());
    }

    @Override
    public List<Purchase> listPurchase() {
        return this.mapperPurchase.entityToModelList(this.jpaPurchaseRepository.findAll());
    }

    @Override
    public boolean deletePurchase(long id) {
        try{
            this.jpaPurchaseRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.info("Error deleting purchase");
            return false;
        }
    }

    @Override
    public Purchase updatePurchase(long id, Purchase newPurchase) {
        EntityPurchase entityPurchase = this.mapperPurchase.modelToEntity(newPurchase);
        String newPurchaseDate = newPurchase.getPurchaseDate();
        EntityPurchase entityPurchaseUpdated = this.jpaPurchaseRepository.findById(id)
                .map(purchase ->{
                    purchase.setIdEntity(newPurchase.getId());
                    purchase.setNumberPurchasedTicketsEntity(newPurchase.getNumberPurchasedTickets());
                    purchase.setTicketAmountEntity(newPurchase.getTicketAmount());
                    purchase.setDiscountPercentageEntity(newPurchase.getDiscountPercentage());
                    purchase.setTotalPurchaseAmountEntity(newPurchase.getTotalPurchaseAmount());
                    purchase.setIdTripEntity(newPurchase.getIdTrip());
                    purchase.setPurchaseDateEntity(newPurchaseDate);
                    return jpaPurchaseRepository.save(purchase);
                }).orElseGet(() ->{
                    entityPurchase.setIdEntity(id);
                    entityPurchase.setNumberPurchasedTicketsEntity(newPurchase.getNumberPurchasedTickets());
                    entityPurchase.setTicketAmountEntity(newPurchase.getTicketAmount());
                    entityPurchase.setDiscountPercentageEntity(newPurchase.getDiscountPercentage());
                    entityPurchase.setTotalPurchaseAmountEntity(newPurchase. getTotalPurchaseAmount());
                    entityPurchase.setIdTripEntity(newPurchase.getIdTrip());
                    entityPurchase.setPurchaseDateEntity(newPurchaseDate);
                    return jpaPurchaseRepository.save(entityPurchase);
                });
        return new Purchase(entityPurchaseUpdated.getIdEntity(), entityPurchaseUpdated.getNumberPurchasedTicketsEntity(), entityPurchaseUpdated.getTicketAmountEntity(), entityPurchaseUpdated.getDiscountPercentageEntity(), entityPurchaseUpdated.getTotalPurchaseAmountEntity(), entityPurchaseUpdated.getIdTripEntity(), entityPurchaseUpdated.getPurchaseDateEntity(), entityPurchaseUpdated.getTripDateEntity());
    }
}
