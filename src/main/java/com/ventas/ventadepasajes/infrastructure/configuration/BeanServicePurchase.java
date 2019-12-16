package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceCreatePurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceDeletePurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceListPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceUpdatePurchase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicePurchase {

    @Bean
    public ServiceCreatePurchase serviceCreatePurchase(RepositoryPurchase repositoryPurchase){
        return new ServiceCreatePurchase(repositoryPurchase);
    }

    @Bean
    public ServiceDeletePurchase serviceDeletePurchase(RepositoryPurchase repositoryPurchase){
        return new ServiceDeletePurchase(repositoryPurchase);
    }

    @Bean
    public ServiceUpdatePurchase serviceUpdatePurchase(RepositoryPurchase repositoryPurchase){
        return new ServiceUpdatePurchase(repositoryPurchase);
    }

    @Bean
    public ServiceListPurchase serviceListPurchase(RepositoryPurchase repositoryPurchase){
        return new ServiceListPurchase(repositoryPurchase);
    }
}
