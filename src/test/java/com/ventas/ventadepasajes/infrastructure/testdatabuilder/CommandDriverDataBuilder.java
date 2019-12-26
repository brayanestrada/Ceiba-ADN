package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;

public class CommandDriverDataBuilder {

    private static final String name = "Brayan";
    private static final String lastName = "Estrada";
    private static final String identification = "1017275333";
    private static final String smallName = "A";
    private static final String longName = "Qwertyuiopasdfghjklñzxcvbnmqwertyuiosdfghjklzxcvbnm";
    private static final String smallLastName = "A";
    private static final String longLastName = "Poiuytrewñlkjhdsamnbvcxziuytrewquytrewqrewq";
    private static final String smallIdentification = "123";
    private static final String longIdentification = "10293847856574839";

    public CommandDriver build(){ return new CommandDriver(name, lastName, identification);}

    public CommandDriver buildSmallName() { return new CommandDriver(smallName, lastName, identification); }

    public CommandDriver buildSmallLastName() { return new CommandDriver(name, smallLastName, identification); }

    public CommandDriver buildSmallIdentification() { return new CommandDriver(name, lastName, smallIdentification); }

    public CommandDriver buildLongName() { return new CommandDriver(longName, lastName, identification); }

    public CommandDriver buildLongLastName() { return new CommandDriver(name, longLastName, identification); }

    public CommandDriver buildLongIdentification() { return new CommandDriver(name, lastName, longIdentification); }

    public CommandDriver buildWithoutName() { return new CommandDriver(null, lastName, identification); }

    public CommandDriver buildWithoutLastName() { return new CommandDriver(name, null, identification); }

    public CommandDriver buildWithoutIdentification() { return new CommandDriver(name, lastName, null); }


}
