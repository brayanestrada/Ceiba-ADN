package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.infrastructure.entity.EntityPurchase;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaPurchaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryPurchaseImpl implements RepositoryPurchase {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaPurchaseRepository jpaPurchaseRepository;

    public RepositoryPurchaseImpl(JpaPurchaseRepository jpaPurchaseRepository){this.jpaPurchaseRepository = jpaPurchaseRepository;}

    @Override
    public Purchase createPurchase(Purchase purchase) {
        EntityPurchase entityPurchase = this.modelMapper.map(purchase, EntityPurchase.class);
        EntityPurchase entityPurchaseSaved = this.jpaPurchaseRepository.save(entityPurchase);
        return new Purchase(entityPurchaseSaved.getId(), entityPurchase.getNumberPurchasedTickets(), entityPurchase.getTicketAmount(), purchase.getDiscountPercentage(), purchase.getTotalPurchaseAmount(), purchase.getIdTrip(), purchase.getPurchaseDate(), purchase.getTripDate());
    }

    @Override
    public List<Purchase> listPurchase() {
        List<EntityPurchase> listPurchase = this.jpaPurchaseRepository.findAll();
        return listPurchase.stream().map(e ->Purchase.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public boolean deletePurchase(long id) {
        try{
            this.jpaPurchaseRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return false;
        }
    }

    @Override
    public Purchase updatePurchase(long id, Purchase newPurchase) {
        EntityPurchase entityPurchase = this.modelMapper.map(newPurchase, EntityPurchase.class);
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