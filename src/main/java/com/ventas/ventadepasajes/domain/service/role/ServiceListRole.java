package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;

import java.util.List;

public class ServiceListRole {

    private RepositoryRole repositoryRole;

    public ServiceListRole(RepositoryRole repositoryRole){
        this.repositoryRole = repositoryRole;
    }

    public List<Role> run(){
        return this.repositoryRole.listRole();
    }
}
