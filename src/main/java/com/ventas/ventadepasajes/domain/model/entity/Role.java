package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityRole;

public class Role {

    private long id;
    private String name;

    public Role(){}

    public Role(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Role(String name){
        this.name = name;
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

    public static Role valueOf(EntityRole entityRole){
        Role role = new Role();
        role.setId(entityRole.getId());
        role.setName(entityRole.getName());
        return role;
    }
}
