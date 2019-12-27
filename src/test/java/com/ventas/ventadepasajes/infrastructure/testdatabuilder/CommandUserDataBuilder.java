package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;

public class CommandUserDataBuilder {

    private static final String name = "Brayan";
    private static final String lastName = "Estrada";
    private static final String email = "brayan.estrada@ceiba.com.co";
    private static final String phone = "3013439322";
    private static final long role = 14;
    private static final String password = "Test4echo*";
    private static final String smallName = "A";
    private static final String smallLastName = "A";
    private static final String smallPhone = "123";
    private static final String smallPassword = "qwe";
    private static final String longName = "Qqwertyuiopñlkjhgfdsazxcvbnmñlkjhgfdsaqwertyuiopñlkjhg";
    private static final String longLastName = "POiuytrewqsdfghjklñ,mnbvcxaqweopñlkjhgfdsxcvbn";
    private static final String longPhone = "1238903212345678905432";
    private static final String longPassword = "qwertyuioppñlkjhgfdsaqwertyuioplkjhgfdsaqwertyu";

    public CommandUser build(){ return new CommandUser(name, lastName, email, phone, role, password); }

    public CommandUser buildWithoutName(){ return new CommandUser(null, lastName, email, phone, role, password); }

    public CommandUser buildWithoutLastName(){ return new CommandUser(name, null, email, phone, role, password); }

    public CommandUser buildWithoutEmail(){ return new CommandUser(name, lastName, null, phone, role, password); }

    public CommandUser buildWithoutPhone(){ return new CommandUser(name, lastName, email, null, role, password); }

    public CommandUser buildWithoutRole(){ return new CommandUser(name, lastName, email, phone, 0, password); }

    public CommandUser buildWithoutPassword(){ return new CommandUser(name, lastName, email, phone, role, null); }

    public CommandUser buildSmallName(){ return new CommandUser(smallName, lastName, email, phone, role, password); }

    public CommandUser buildSmallLastName(){ return new CommandUser(name, smallLastName, email, phone, role, password); }

    public CommandUser buildSmallPhone(){ return new CommandUser(name, lastName, email, smallPhone, role, password); }

    public CommandUser buildSmallPassword(){ return new CommandUser(name, lastName, email, phone, role, smallPassword); }

    public CommandUser buildLongName(){ return new CommandUser(longName, lastName, email, phone, role, password); }

    public CommandUser buildLongLastName(){ return new CommandUser(name, longLastName, email, phone, role, password); }

    public CommandUser buildLongPhone(){ return new CommandUser(name, lastName, email, longPhone, role, password); }

    public CommandUser buildLongPassword(){ return new CommandUser(name, lastName, email, phone, role, longPassword); }

    public CommandUser buildWithRoleId(CommandUser commandUser, int roleId){ return new CommandUser(commandUser.getName(), commandUser.getLastName(), commandUser.getEmail(), commandUser.getPhone(), roleId, commandUser.getPassword()); }

}
