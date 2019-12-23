package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;

public class ServiceUpdateRole {

    private RepositoryRole repositoryRole;

    public ServiceUpdateRole(RepositoryRole repositoryRole){
        this.repositoryRole = repositoryRole;
    }

    public Role run(long id, Role role){
        return this.repositoryRole.updateRole(id, role);
    }
}
