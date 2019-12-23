package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;

import java.util.List;

public class ServiceListUser {

    private RepositoryUser repositoryUser;

    public ServiceListUser(RepositoryUser repositoryUser){this.repositoryUser = repositoryUser;}

    public List<User> run(){
        return this.repositoryUser.listUser();
    }
}
