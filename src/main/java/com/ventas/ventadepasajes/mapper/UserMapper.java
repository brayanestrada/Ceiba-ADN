package com.ventas.ventadepasajes.mapper;

import com.ventas.ventadepasajes.dto.UserDto;
import com.ventas.ventadepasajes.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto entityToDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        return dto;
    }

    public User dtoToEntity(UserDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        return user;
    }
}
