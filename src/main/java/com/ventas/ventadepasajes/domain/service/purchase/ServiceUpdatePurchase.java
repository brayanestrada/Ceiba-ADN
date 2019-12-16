package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.mapper.MapperPurchase;

public class ServiceUpdatePurchase {

    private RepositoryPurchase repositoryPurchase;

    public ServiceUpdatePurchase(RepositoryPurchase repositoryPurchase){
        this.repositoryPurchase = repositoryPurchase;
    }

    public DtoPurchase run(long id, Purchase purchase){
        MapperPurchase mapperPurchase = new MapperPurchase();
        return mapperPurchase.entityToDto(this.repositoryPurchase.updatePurchase(id, purchase));
    }
}
