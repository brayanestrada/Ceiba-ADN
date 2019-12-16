package com.ventas.ventadepasajes.domain.service.role.mapper;

import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import com.ventas.ventadepasajes.domain.model.entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class MapperRole {

    public DtoRole entityToDto(Role role){
        return new DtoRole(role.getId(), role.getName());
    }

    public List<DtoRole> entityListToDtoList(List<Role> entityList){
        return entityList.stream().map(e -> DtoRole.valueOf(e)).collect(Collectors.toList());
    }
}
