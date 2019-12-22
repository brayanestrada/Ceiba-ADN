package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.User;

public class UserTestDataBuilder {

    private String name, lastName, email, phone, password;
    private long role;

    public UserTestDataBuilder(){
        this.name = "Brayan";
        this.lastName = "User";
        this.email = "brayan@ceiba.com.co";
        this.phone = "3013439323";
        this.role = 1;
        this.password = "asdasd";
    }

    public void withoutName(){ this.name = null; }

    public void withoutLastName(){ this.lastName = null; }

    public void withoutEmail(){ this.email = null; }

    public void withoutPhone(){ this.phone = null; }

    public void withoutRole(){ this.role = 0; }

    public void withoutPassword(){ this.password = null; }

    public void smallName(){ this.name = "A"; }

    public void smallLastName(){ this.lastName = "A"; }

    public void smallPhone(){ this.phone = "A"; }

    public void smallPassword(){ this.password = "A"; }

    public void longName(){ this.name = "A123456789012345678901234567890123123"; }

    public void longLastName(){ this.name = "A123456789012345678901234567890123123"; }

    public void longPhone(){ this.lastName = "A123456789012345678901234567890123123"; }

    public void longPassword(){ this.lastName = "A123456789012345678901234567890123123"; }

    public User build(){return new User(name, lastName, email,phone, role, password);}
}
