package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Role;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
