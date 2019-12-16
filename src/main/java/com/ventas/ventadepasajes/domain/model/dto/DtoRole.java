package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoRole {
    private long id;
    private String name;

    public DtoRole(){}

    public DtoRole(long id, String name){
        this.id = id;
        this.name = name;
    }

    public DtoRole(String name){
        this.name = name;
    }

    public static DtoRole valueOf(Role role){
        DtoRole dtoRole = new DtoRole();
        dtoRole.setId(role.getId());
        dtoRole.setName(role.getName());
        return dtoRole;
    }
}
