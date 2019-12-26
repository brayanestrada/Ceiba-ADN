package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;

public class CommandRoleDataBuilder {

    private static final long id = 1;
    private static final String name = "Administrator";
    private static final String smallName = "A";
    private static final String longName = "This message is to test a new role with more than 35 characters, to test if the validation is done";

    public CommandRole build() { return new CommandRole(id, name); }

    public CommandRole buildWithoutName() { return new CommandRole(id, null); }

    public CommandRole buildSmallName() { return new CommandRole(id, smallName); }

    public CommandRole buildLongName() { return new CommandRole(id, longName); }

}
