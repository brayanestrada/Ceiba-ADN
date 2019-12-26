package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.domain.service.user.*;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceUser {

    @Bean
    public ServiceCreateUser serviceCreateuser(RepositoryUser repositoryUser, RepositoryRole repositoryRole){
        return new ServiceCreateUser(repositoryUser, repositoryRole);
    }

    @Bean
    public ServiceDeleteUser serviceDeleteUser(RepositoryUser repositoryUser){
        return new ServiceDeleteUser(repositoryUser);
    }

    @Bean
    public ServiceUpdateUser serviceUpdateUser(RepositoryUser repositoryUser){
        return new ServiceUpdateUser(repositoryUser);
    }

    @Bean
    public ServiceListUser serviceListUser(RepositoryUser repositoryUser){
        return new ServiceListUser(repositoryUser);
    }

    @Bean
    public ServiceLogIn serviceLogIn(RepositoryUser repositoryUser){
        return new ServiceLogIn(repositoryUser);
    }
}
