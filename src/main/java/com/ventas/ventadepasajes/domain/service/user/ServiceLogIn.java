package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;

public class ServiceLogIn {

    private RepositoryUser repositoryUser;

    public ServiceLogIn(RepositoryUser repositoryUser){
        this.repositoryUser = repositoryUser;
    }

    public User run(String email, String password){
        return this.repositoryUser.logIn(email, password);
    }
}
