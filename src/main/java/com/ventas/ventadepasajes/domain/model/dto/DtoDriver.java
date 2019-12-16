package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoDriver {

    private Long id;
    private String name;
    private String lastName;
    private String identification;

    public DtoDriver(){}

    public DtoDriver(Long id, String name, String lastName, String identification){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
    }

    public DtoDriver( String name, String lastName, String identification){
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
    }

    public static DtoDriver valueOf(Driver entity){
        DtoDriver dto = new DtoDriver();
        dto.setId(entity.getId());
        dto.setName(String.valueOf(entity.getName()));
        dto.setLastName(String.valueOf(entity.getLastName()));
        dto.setIdentification(String.valueOf(entity.getIdentification()));
        return dto;
    }
}
