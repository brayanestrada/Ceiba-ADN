package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.Getter;

@Getter
public class CommandDriver {
    private Long id;
    private String name;
    private String lastName;
    private String identification;

    public CommandDriver(Long id, String name, String lastName, String identification){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
    }
}
