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

    public DtoUser(){}

    public DtoUser(Long id, String name, String lastName, String email, String phone){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public static DtoUser valueOf(User user){
        DtoUser dto = new DtoUser();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }
}
