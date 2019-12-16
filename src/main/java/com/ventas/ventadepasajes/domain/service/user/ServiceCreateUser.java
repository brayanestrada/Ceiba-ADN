package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;

public class ServiceCreateUser {

    private RepositoryUser repositoryUser;

    public ServiceCreateUser(RepositoryUser repositoryUser){
        this.repositoryUser = repositoryUser;
    }

    public User run(User user){
        return this.repositoryUser.createUser(user);
    }
}
