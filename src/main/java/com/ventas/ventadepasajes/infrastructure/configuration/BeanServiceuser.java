package com.ventas.ventadepasajes.infrastructure.configuration;

import com.ventas.ventadepasajes.domain.service.client.ServiceCreateUser;
import com.ventas.ventadepasajes.port.repository.RepositoryUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceuser {

    @Bean
    public ServiceCreateUser serviceCreateuser(RepositoryUser repositoryUser){
        return new ServiceCreateUser(repositoryUser);
    }
}
