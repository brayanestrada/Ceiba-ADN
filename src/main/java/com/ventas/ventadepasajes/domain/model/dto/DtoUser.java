package com.ventas.ventadepasajes.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUser {
    private Long id;
    private String name;
    private String lastName;

    public DtoUser(){}

    public DtoUser(Long id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
