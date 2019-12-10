package com.ventas.ventadepasajes.aplication.command;

import lombok.Getter;

@Getter
public class CommandUser {

    private Long id;
    private String name;
    private String lastName;

    public CommandUser(Long id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    public CommandUser(){}
}
