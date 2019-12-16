package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryDriver;
import com.ventas.ventadepasajes.domain.service.driver.ServiceCreateDriver;
import com.ventas.ventadepasajes.domain.service.driver.ServiceDeleteDriver;
import com.ventas.ventadepasajes.domain.service.driver.ServiceListDriver;
import com.ventas.ventadepasajes.domain.service.driver.ServiceUpdateDriver;
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

    @Bean
    public ServiceDeleteDriver serviceDeleteDriver(RepositoryDriver repositoryDriver){
        return new ServiceDeleteDriver(repositoryDriver);
    }

    @Bean
    public ServiceUpdateDriver serviceUpdateDriver(RepositoryDriver repositoryDriver){
        return new ServiceUpdateDriver(repositoryDriver);
    }
}
