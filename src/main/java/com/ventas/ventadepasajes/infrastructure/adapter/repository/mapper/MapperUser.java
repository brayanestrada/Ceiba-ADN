package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUser {

    public List<User> entityToModelList(List<EntityUser> entityList){
        return entityList.stream().map(MapperUser::valueOfModel).collect(Collectors.toList());
    }

    public static User valueOfModel(EntityUser entity){
        User user = new User();
        user.setLastName(entity.getLastName());
        user.setId(entity.getId());
        user.setPhone(entity.getPhone());
        user.setPassword(entity.getPassword());
        user.setName(entity.getName());
        user.setRole(entity.getRole());
        return user;
    }
}
