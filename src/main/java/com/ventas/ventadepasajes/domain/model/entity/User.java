package com.ventas.ventadepasajes.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String lastName;
    //TODO : Validations
    public User(Long id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
