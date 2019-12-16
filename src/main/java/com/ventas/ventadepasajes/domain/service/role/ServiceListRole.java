package com.ventas.ventadepasajes.domain.service.role;

import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.domain.service.role.mapper.MapperRole;

import java.util.List;

public class ServiceListRole {

    private RepositoryRole repositoryRole;

    public ServiceListRole(RepositoryRole repositoryRole){
        this.repositoryRole = repositoryRole;
    }

    public List<DtoRole> run(){
        MapperRole mapperRole = new MapperRole();
        List<Role> listRole = this.repositoryRole.listRole();
        return mapperRole.entityListToDtoList(listRole);
    }
}
