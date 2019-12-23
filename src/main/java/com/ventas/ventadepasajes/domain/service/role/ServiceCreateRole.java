package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;

public class ServiceCreateRole {

    private RepositoryRole repositoryRole;

    public ServiceCreateRole(RepositoryRole repositoryRole){
        this.repositoryRole = repositoryRole;
    }

    public Role run(Role role){
        return this.repositoryRole.createRole(role);
    }
}
