package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.User;
import com.ventas.ventadepasajes.port.repository.RepositoryUser;

public class ServiceCreateUser {

    private RepositoryUser repositoryUser;

    public ServiceCreateUser(RepositoryUser repositoryUser){
        this.repositoryUser = repositoryUser;
    }

    public void run(User user){
        this.repositoryUser.createUser(user);
    }
}
