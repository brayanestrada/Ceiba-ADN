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

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastName() {
        return lastName;
    }

    public long getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
