package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.domain.service.role.ServiceCreateRole;
import com.ventas.ventadepasajes.domain.service.role.ServiceDeleteRole;
import com.ventas.ventadepasajes.domain.service.role.ServiceListRole;
import com.ventas.ventadepasajes.domain.service.role.ServiceUpdateRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceRole {

    @Bean
    public ServiceCreateRole serviceCreateRole(RepositoryRole repositoryRole){
        return new ServiceCreateRole(repositoryRole);
    }

    @Bean
    public ServiceDeleteRole serviceDeleteRole(RepositoryRole repositoryRole){
        return new ServiceDeleteRole(repositoryRole);
    }

    @Bean
    public ServiceUpdateRole serviceUpdateRole(RepositoryRole repositoryRole){
        return new ServiceUpdateRole(repositoryRole);
    }

    @Bean
    public ServiceListRole serviceListRole(RepositoryRole repositoryRole){
        return new ServiceListRole(repositoryRole);
    }
}
