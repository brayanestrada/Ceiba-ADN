package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.domain.service.role.mapper.MapperRole;

public class ServiceUpdateRole {

    private RepositoryRole repositoryRole;

    public ServiceUpdateRole(RepositoryRole repositoryRole){
        this.repositoryRole = repositoryRole;
    }

    public DtoRole run(long id, Role role){
        MapperRole mapperRole = new MapperRole();
        return mapperRole.entityToDto(this.repositoryRole.updateRole(id, role));
    }
}
