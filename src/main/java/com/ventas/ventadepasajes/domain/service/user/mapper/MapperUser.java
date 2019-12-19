package com.ventas.ventadepasajes.domain.service.user.mapper;

import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUser {

    public DtoUser entityToDto(User user){
        return new DtoUser(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getRole());
    }

    public List<DtoUser> entityListToDtoList(List<User> listUser){
        return listUser.stream().map(e -> DtoUser.valueOf(e)).collect(Collectors.toList());
    }
}
