package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;

public class ServiceDeletePurchase {
    private RepositoryPurchase repositoryPurchase;

    public ServiceDeletePurchase(RepositoryPurchase repositoryPurchase){
        this.repositoryPurchase = repositoryPurchase;
    }

    public boolean run(long id){return this.repositoryPurchase.deletePurchase(id);}
}
