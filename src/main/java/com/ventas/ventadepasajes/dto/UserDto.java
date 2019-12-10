package com.ventas.ventadepasajes.dto;

import lombok.Data;

public class UserDto {

    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    private String name;

    private String LastName;
}
