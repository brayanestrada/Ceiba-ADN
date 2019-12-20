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

    public CommandUser(Long id, String name, String lastName, String email, String phone, long role, String password){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }

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
