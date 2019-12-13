package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.service.destination.ServiceCreateDestination;
import com.ventas.ventadepasajes.domain.service.driver.ServiceCreateDriver;
import com.ventas.ventadepasajes.domain.service.driver.ServiceListDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceDriver {

    @Bean
    public ServiceCreateDriver serviceCreateDriver(RepositoryDriver repositoryDriver){
        return new ServiceCreateDriver(repositoryDriver);
    }

    @Bean
    public ServiceListDriver serviceListDriver(RepositoryDriver repositoryDriver){
        return new ServiceListDriver(repositoryDriver);
    }
}
