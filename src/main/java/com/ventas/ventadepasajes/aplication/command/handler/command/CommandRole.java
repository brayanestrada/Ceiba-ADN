package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandRole {

    private long id;
    private String name;

    public CommandRole(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
