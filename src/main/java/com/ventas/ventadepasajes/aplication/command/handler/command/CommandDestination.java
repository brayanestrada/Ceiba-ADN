package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandDestination {

    private String name;

    public CommandDestination(){}

    public CommandDestination(String name){ this.name = name; }

    public String getName() {
        return name;
    }
}
