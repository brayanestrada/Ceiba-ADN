package com.ventas.ventadepasajes.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    private Long id;
    private String name;
    private String lastName;

    public User(Long id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
