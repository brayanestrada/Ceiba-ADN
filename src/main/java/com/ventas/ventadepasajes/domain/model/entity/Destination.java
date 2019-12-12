package com.ventas.ventadepasajes.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Destination {

    private Long id;
    private String name;

    public Destination(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
