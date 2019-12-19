package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.domain.service.role.mapper.MapperRole;

public class ServiceSearchRole {

    private RepositoryRole repositoryRole;

    public ServiceSearchRole(RepositoryRole repositoryRole){ this.repositoryRole = repositoryRole; }

    public DtoRole run(long id){
        MapperRole mapperRole = new MapperRole();
        Role role = this.repositoryRole.searchRole(id);
        return mapperRole.entityToDto(role);
    }
}
