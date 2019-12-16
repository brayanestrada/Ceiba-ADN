package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;

public class CommandDriverDataBuilder {

    private String name;
    private String lastName;
    private String identification;

    public CommandDriverDataBuilder(){
        this.name = "Brayan";
        this.lastName = "Driver";
        this.identification = "1017275353";
    }

    public CommandDriver build(){ return new CommandDriver(name, lastName, identification);}
}
