package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.Destination;

public class DestinationTestDataBuilder {

    private String name;

    public DestinationTestDataBuilder(){
        this.name = "Brayan";
    }

    public void smallName(){
        this.name = "as";
    }

    public void longName(){
        this.name = "Esta es una prueba de longitud de más de 30 caracteres";
    }

    public void withName(String name){
        this.name = name;
    }

    public Destination build(){
        return new Destination(name);
    }
}
