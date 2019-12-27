package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;

public class ServiceSearchRole {

    private RepositoryRole repositoryRole;

    public ServiceSearchRole(RepositoryRole repositoryRole){ this.repositoryRole = repositoryRole; }

    public boolean run(long id){
        return this.repositoryRole.searchRole(id);
    }
}
