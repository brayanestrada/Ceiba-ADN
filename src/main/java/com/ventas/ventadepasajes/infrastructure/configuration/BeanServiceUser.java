package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.service.user.ServiceCreateUser;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import com.ventas.ventadepasajes.domain.service.user.ServiceDeleteUser;
import com.ventas.ventadepasajes.domain.service.user.ServiceListUser;
import com.ventas.ventadepasajes.domain.service.user.ServiceUpdateUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceUser {

    @Bean
    public ServiceCreateUser serviceCreateuser(RepositoryUser repositoryUser){
        return new ServiceCreateUser(repositoryUser);
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
}
