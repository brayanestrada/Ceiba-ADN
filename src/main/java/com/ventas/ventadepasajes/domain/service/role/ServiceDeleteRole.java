package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;

public class ServiceDeleteRole {

    private RepositoryRole repositoryRole;

    public ServiceDeleteRole(RepositoryRole repositoryRole){this.repositoryRole = repositoryRole;}

    public boolean run(long id){
        return this.repositoryRole.deleteRole(id);
    }
}
