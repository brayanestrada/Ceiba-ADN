package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.domain.service.role.mapper.MapperRole;

public class ServiceCreateRole {

    private RepositoryRole repositoryRole;

    public ServiceCreateRole(RepositoryRole repositoryRole){
        this.repositoryRole = repositoryRole;
    }

    public DtoRole run(Role role){
        MapperRole mapperRole = new MapperRole();
        return mapperRole.entityToDto(this.repositoryRole.createRole(role));
    }
}
