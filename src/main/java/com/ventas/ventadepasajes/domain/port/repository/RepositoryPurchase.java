package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPurchase {

    Purchase createPurchase(Purchase purchase);

    List<Purchase> listPurchase();

    boolean deletePurchase(long id);

    Purchase updatePurchase(long id, Purchase purchase);
}
