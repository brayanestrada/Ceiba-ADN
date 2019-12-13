package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.Driver;

public class DriverTestDataBuilder {

    private String name, lastName, identification;

    public DriverTestDataBuilder(){
        this.name = "Brayan";
        this.lastName = "Driver";
        this.identification = "1017275353";
    }

    public void smallName(){this.name = "A";}

    public void longName(){this.name = "A123456789012345678901234567890123123";}

    public void withName(String name){this.name = name;}

    public void smallLastName(){this.lastName = "A";}

    public void longLastName(){this.lastName = "A123456789012345678901234567890123123";}

    public void withLastName(String lastName){this.lastName = lastName;}

    public void smallIdentification(){this.identification = "123123";}

    public void longIdentification(){this.identification = "123123123123123";}

    public void withIdentification(String identification){this.identification = identification;}

    public Driver build(){return new Driver(name, lastName, identification);}
}
