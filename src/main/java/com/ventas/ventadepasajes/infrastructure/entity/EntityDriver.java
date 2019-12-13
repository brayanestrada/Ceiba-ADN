package com.ventas.ventadepasajes.infrastructure.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_driver")
public class EntityDriver {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String identification;

    public EntityDriver(){}

    public EntityDriver(Long id, String name, String lastName, String identification){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

}
