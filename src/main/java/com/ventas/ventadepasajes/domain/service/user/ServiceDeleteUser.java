package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;

public class ServiceDeleteUser {

    private RepositoryUser repositoryUser;

    public ServiceDeleteUser(RepositoryUser repositoryUser){ this.repositoryUser = repositoryUser; }

    public boolean run(long id){return this.repositoryUser.deleteUser(id);}
}