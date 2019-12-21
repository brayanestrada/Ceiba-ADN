package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.service.purchase.mapper.MapperPurchase;

public class ServiceUpdatePurchase {

    private RepositoryPurchase repositoryPurchase;
    private RepositoryTrip repositoryTrip;

    public ServiceUpdatePurchase(RepositoryPurchase repositoryPurchase, RepositoryTrip repositoryTrip){
        this.repositoryPurchase = repositoryPurchase;
        this.repositoryTrip = repositoryTrip;
    }

    public DtoPurchase run(long id, Purchase newPurchase){
        MapperPurchase mapper = new MapperPurchase();
        Trip trip = getTrip(newPurchase.getIdTrip());
        newPurchase.setTicketAmount(trip.getTicketAmount());
        double totalWithoutDiscount = newPurchase.getNumberPurchasedTickets() * newPurchase.getTicketAmount();
        if(newPurchase.getNumberPurchasedTickets()>4){
            newPurchase.setTicketAmount(trip.getTicketAmount());
            newPurchase.setPurchaseDate(trip.getTripDate());
            newPurchase.setDiscountPercentage(10);
            double discountAmount = totalWithoutDiscount*(newPurchase.getDiscountPercentage())/100;
            newPurchase.setTotalPurchaseAmount(totalWithoutDiscount-discountAmount);
        }else{
            newPurchase.setDiscountPercentage(0);
            newPurchase.setTotalPurchaseAmount(totalWithoutDiscount);
        }


        return mapper.entityToDto(this.repositoryPurchase.updatePurchase(id, newPurchase));
    }

    public Trip getTrip(long id){
        return this.repositoryTrip.searchTrip(id);
    }
}
