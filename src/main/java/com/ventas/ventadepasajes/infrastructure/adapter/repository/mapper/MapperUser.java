package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.model.entity.dto.UserDto;
import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUser {

    public List<User> entityToModelList(List<EntityUser> entityList){
        return entityList.stream().map(MapperUser::valueOfModel).collect(Collectors.toList());
    }

    private static User valueOfModel(EntityUser entity){
        return new User(entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getRole(),
                entity.getPassword()
        );
    }

    public User entityToModel(EntityUser entityUser){
        return new User(entityUser.getId(), entityUser.getName(), entityUser.getLastName(), entityUser.getEmail(),
                entityUser.getPhone(), entityUser.getRole(), entityUser.getPassword());
    }

    public EntityUser modelToEntity(User user){
        return new EntityUser(user.getId(), user.getName(), user.getLastName(), user.getEmail(),
                user.getPhone(), user.getRole(), user.getPassword());
    }

    public UserDto modelToDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getRole());
    }
}
