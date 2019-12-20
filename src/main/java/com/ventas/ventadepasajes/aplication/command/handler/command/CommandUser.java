package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandUser {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private long role;
    private String password;

    public CommandUser(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public long getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
