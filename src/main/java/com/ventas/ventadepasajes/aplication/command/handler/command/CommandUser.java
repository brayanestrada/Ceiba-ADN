package com.ventas.ventadepasajes.aplication.command.handler.command;

public class CommandUser {

    private String name;
    private String phone;
    private String lastName;
    private String email;
    private String password;
    private long role;

    public CommandUser(String name, String lastName, String email, String phone, long role, String password){
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
    }

    public String getNameCommand() {
        return name;
    }

    public String getPhoneCommand() {
        return phone;
    }

    public String getLastNameCommand() {
        return lastName;
    }

    public long getRoleCommand() {
        return role;
    }

    public String getEmailCommand() {
        return email;
    }

    public String getPasswordCommand() {
        return password;
    }


}
