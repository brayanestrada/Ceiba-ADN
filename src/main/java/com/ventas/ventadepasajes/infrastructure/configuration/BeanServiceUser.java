package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.service.user.ServiceCreateUser;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceUser {

    @Bean
    public ServiceCreateUser serviceCreateuser(RepositoryUser repositoryUser){
        return new ServiceCreateUser(repositoryUser);
    }
}