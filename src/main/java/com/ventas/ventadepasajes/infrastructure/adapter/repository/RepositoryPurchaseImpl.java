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
        return new Purchase(entityPurchaseSaved.getId(), entityPurchase.getNumberPurchasedTickets(), entityPurchase.getTicketAmount(), purchase.getDiscountPercentage(), purchase.getTotalPurchaseAmount(), purchase.getIdTrip(), purchase.getPurchaseDate(), purchase.getTripDate());
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
                    purchase.setId(newPurchase.getId());
                    purchase.setNumberPurchasedTickets(newPurchase.getNumberPurchasedTickets());
                    purchase.setTicketAmount(newPurchase.getTicketAmount());
                    purchase.setDiscountPercentage(newPurchase.getDiscountPercentage());
                    purchase.setTotalPurchaseAmount(newPurchase.getTotalPurchaseAmount());
                    purchase.setIdTrip(newPurchase.getIdTrip());
                    purchase.setPurchaseDate(newPurchaseDate);
                    return jpaPurchaseRepository.save(purchase);
                }).orElseGet(() ->{
                    entityPurchase.setId(id);
                    entityPurchase.setNumberPurchasedTickets(newPurchase.getNumberPurchasedTickets());
                    entityPurchase.setTicketAmount(newPurchase.getTicketAmount());
                    entityPurchase.setDiscountPercentage(newPurchase.getDiscountPercentage());
                    entityPurchase.setTotalPurchaseAmount(newPurchase. getTotalPurchaseAmount());
                    entityPurchase.setIdTrip(newPurchase.getIdTrip());
                    entityPurchase.setPurchaseDate(newPurchaseDate);
                    return jpaPurchaseRepository.save(entityPurchase);
                });
        return new Purchase(entityPurchaseUpdated.getId(), entityPurchaseUpdated.getNumberPurchasedTickets(), entityPurchaseUpdated.getTicketAmount(), entityPurchaseUpdated.getDiscountPercentage(), entityPurchaseUpdated.getTotalPurchaseAmount(), entityPurchaseUpdated.getIdTrip(), entityPurchaseUpdated.getPurchaseDate(), entityPurchaseUpdated.getTripDate());
    }
}
