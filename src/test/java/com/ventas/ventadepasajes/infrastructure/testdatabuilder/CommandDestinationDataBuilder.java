package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDestination;

public class CommandDestinationDataBuilder {

    private String name;

    public CommandDestinationDataBuilder(){
        this.name = "Barranquilla";
    }

    public CommandDestinationDataBuilder withName(String name){
        this.name = name;
        return this;
    }

    public CommandDestination build(){return new CommandDestination(name);}
}
