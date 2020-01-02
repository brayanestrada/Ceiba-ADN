package com.ventas.ventadepasajes.infrastructure.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_driver")
public class EntityDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String identification;

    private EntityDriver(){ }

    public EntityDriver(Long id, String name, String lastName, String identification){
        this.id = id;
        this.name = name;
        this.identification = identification;
        this.lastName = lastName;
    }

    public Long getIdEntity() { return id; }

    public void setIdEntity(Long id) { this.id = id; }

    public String getNameEntity() {
        return name;
    }

    public void setNameEntity(String name) {
        this.name = name;
    }

    public String getLastNameEntity() {
        return lastName;
    }

    public void setLastNameEntity(String lastName) { this.lastName = lastName; }

    public String getIdentificationEntity() {
        return identification;
    }

    public void setIdentificationEntity(String identification) { this.identification = identification; }
}
