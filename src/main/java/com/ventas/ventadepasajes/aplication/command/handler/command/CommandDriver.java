package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandDriver {

    private String name;
    private String lastName;
    private String identification;

    public CommandDriver(){}

    public CommandDriver(String name, String lastName, String identification){
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentification() {
        return identification;
    }
}
