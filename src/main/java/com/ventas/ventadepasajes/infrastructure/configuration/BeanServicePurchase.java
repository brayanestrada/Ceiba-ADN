package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceCreatePurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceDeletePurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceListPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceUpdatePurchase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicePurchase {

    @Bean
    public ServiceCreatePurchase serviceCreatePurchase(RepositoryPurchase repositoryPurchase, RepositoryTrip repositoryTrip){
        return new ServiceCreatePurchase(repositoryPurchase, repositoryTrip);
    }

    @Bean
    public ServiceDeletePurchase serviceDeletePurchase(RepositoryPurchase repositoryPurchase){
        return new ServiceDeletePurchase(repositoryPurchase);
    }

    @Bean
    public ServiceUpdatePurchase serviceUpdatePurchase(RepositoryPurchase repositoryPurchase, RepositoryTrip repositoryTrip){
        return new ServiceUpdatePurchase(repositoryPurchase, repositoryTrip);
    }

    @Bean
    public ServiceListPurchase serviceListPurchase(RepositoryPurchase repositoryPurchase){
        return new ServiceListPurchase(repositoryPurchase);
    }
}
