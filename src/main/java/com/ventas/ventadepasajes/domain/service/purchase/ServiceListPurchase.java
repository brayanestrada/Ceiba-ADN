package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;

import java.util.List;

public class ServiceListPurchase {

    private RepositoryPurchase repositoryPurchase;

    public ServiceListPurchase(RepositoryPurchase repositoryPurchase){
        this.repositoryPurchase = repositoryPurchase;
    }

    public List<Purchase> run(){
        return this.repositoryPurchase.listPurchase();
    }
}
