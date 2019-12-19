package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUser {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private long role;

    public DtoUser(){}

    public DtoUser(Long id, String name, String lastName, String email, String phone, long role){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public static DtoUser valueOf(User user){
        DtoUser dtoUser = new DtoUser();
        dtoUser.setId(user.getId());
        dtoUser.setName(user.getName());
        dtoUser.setLastName(user.getLastName());
        dtoUser.setEmail(user.getEmail());
        dtoUser.setPhone(user.getPhone());
        dtoUser.setRole(user.getRole());
        return dtoUser;
    }
}
