package com.ventas.ventadepasajes.infrastructure.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_role")
public class EntityRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private EntityRole(){}

    public EntityRole(long id, String name){
        this.name = name;
        this.id = id;
    }

    public long getIdEntity() {
        return id;
    }

    public void setIdEntity(long id) {
        this.id = id;
    }

    public String getNameEntity() {
        return name;
    }

    public void setNameEntity(String name) {
        this.name = name;
    }

}
