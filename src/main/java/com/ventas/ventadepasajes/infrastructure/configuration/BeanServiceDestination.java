package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryDestination;
import com.ventas.ventadepasajes.domain.service.destination.ServiceCreateDestination;
import com.ventas.ventadepasajes.domain.service.destination.ServiceListDestination;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceDestination {

    @Bean
    public ServiceCreateDestination serviceCreateDestination(RepositoryDestination repositoryDestination){
        return new ServiceCreateDestination(repositoryDestination);
    }

    @Bean
    public ServiceListDestination serviceListDestination(RepositoryDestination repositoryDestination){
        return new ServiceListDestination(repositoryDestination);
    }
}
