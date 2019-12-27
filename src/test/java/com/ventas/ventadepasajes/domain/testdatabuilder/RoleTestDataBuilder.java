package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.Role;

public class RoleTestDataBuilder {

    private long id;
    private String name;

    public RoleTestDataBuilder(){
        this.id = 1;
        this.name = "Administrator";
    }

    public void withoutName(){
        this.name = null;
    }

    public void shortName(){
        this.name = "A";
    }

    public void longName(){
        this.name = "This message is to test a new role with more than 35 characters, to test if the validation is done";
    }

    public Role build(){return new Role(this.name);}

    public Role buildWithId(){return new Role(this.id, this.name);}
}
