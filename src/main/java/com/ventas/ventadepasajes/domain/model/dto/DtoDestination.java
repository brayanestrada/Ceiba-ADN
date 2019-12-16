package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Destination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoDestination {

    private Long id;
    private String name;

    public DtoDestination(){ }

    public DtoDestination(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public static DtoDestination valueOf(Destination entity){
        DtoDestination dto = new DtoDestination();
        dto.setId(entity.getId());
        dto.setName(String.valueOf(entity.getName()));
        return dto;
    }

    public DtoDestination(String name){
        this.name = name;
    }
}
