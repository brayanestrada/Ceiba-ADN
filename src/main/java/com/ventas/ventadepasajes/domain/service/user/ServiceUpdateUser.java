package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;

public class ServiceUpdateUser {

    private RepositoryUser repositoryUser;

    public ServiceUpdateUser(RepositoryUser repositoryUser){
        this.repositoryUser = repositoryUser;
    }

    public User run(long id, User user){
        return this.repositoryUser.updateUser(id, user);
    }
}
