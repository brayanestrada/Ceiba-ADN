package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;
import com.ventas.ventadepasajes.domain.service.trip.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceTrip {

    @Bean
    public ServiceCreateTrip serviceCreateTrip(RepositoryTrip repositoryTrip, RepositoryDriver repositoryDriver){
        return new ServiceCreateTrip(repositoryTrip, repositoryDriver);
    }

    @Bean
    public ServiceListTrip serviceListTrip(RepositoryTrip repositoryTrip){
        return new ServiceListTrip(repositoryTrip);
    }

    @Bean
    public ServiceDeleteTrip serviceDeleteTrip(RepositoryTrip repositoryTrip){
        return new ServiceDeleteTrip(repositoryTrip);
    }

    @Bean
    public ServiceUpdateTrip serviceUpdateTrip(RepositoryTrip repositoryTrip, RepositoryDriver repositoryDriver){
        return new ServiceUpdateTrip(repositoryTrip, repositoryDriver);
    }

    @Bean
    public ServiceSearchTrip serviceSearchTrip(RepositoryTrip repositoryTrip){
        return new ServiceSearchTrip(repositoryTrip);
    }
}

