package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Driver;

public class DtoDriver {

    private Long id;
    private String name;
    private String lastName;
    private String identification;

    public DtoDriver(){}

    public DtoDriver(Long id, String name, String lastName, String identification){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
    }

    public DtoDriver( String name, String lastName, String identification){
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
    }

    public static DtoDriver valueOf(Driver entity){
        DtoDriver dto = new DtoDriver();
        dto.setId(entity.getId());
        dto.setName(String.valueOf(entity.getName()));
        dto.setLastName(String.valueOf(entity.getLastName()));
        dto.setIdentification(String.valueOf(entity.getIdentification()));
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
