package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.infrastructure.entity.EntityRole;

import java.util.List;
import java.util.stream.Collectors;

public class MapperRole {

    public List<Role> entityToModelList(List<EntityRole> entityList){
        return entityList.stream().map(MapperRole::valueOfModel).collect(Collectors.toList());
    }

    public static Role valueOfModel(EntityRole entityRole){
        Role role = new Role();
        role.setId(entityRole.getId());
        role.setName(entityRole.getName());
        return role;
    }

}
