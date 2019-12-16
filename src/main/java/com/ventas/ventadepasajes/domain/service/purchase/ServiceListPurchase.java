package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.mapper.MapperPurchase;

import java.util.List;

public class ServiceListPurchase {

    private RepositoryPurchase repositoryPurchase;

    public ServiceListPurchase(RepositoryPurchase repositoryPurchase){
        this.repositoryPurchase = repositoryPurchase;
    }

    public List<DtoPurchase> run(){
        MapperPurchase mapperPurchase = new MapperPurchase();
        List<Purchase> listPurchase = this.repositoryPurchase.listPurchase();
        return mapperPurchase.entityListToDtoList(listPurchase);
    }
}
