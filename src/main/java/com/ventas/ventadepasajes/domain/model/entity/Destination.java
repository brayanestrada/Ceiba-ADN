package com.ventas.ventadepasajes.domain.model.entity;
import com.ventas.ventadepasajes.infrastructure.entity.EntityDestination;

import static com.ventas.ventadepasajes.domain.model.entity.DataValidator.*;

public class Destination {

    private static final int DESTINATION_MIN_LENGTH = 3;
    private static final int DESTINATION_MAX_LENGTH = 30;
    private static final String NAME_IS_MANDATORY = "Name is mandatory";
    private static final String ERROR_NAME_MIN_LENGTH = "Name must have min " + DESTINATION_MIN_LENGTH + " characters";
    private static final String ERROR_NAME_MAX_LENGTH = "Name must have max " + DESTINATION_MAX_LENGTH + " characters";

    private Long id;
    private String name;

    public  Destination(){}

    public Destination(Long id, String name){
        this.id = id;
        this.name = name;
        validateName();
    }

    public Destination(String name){
        this.name = name;
        validateName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void validateName(){
        validateMandatory(name, NAME_IS_MANDATORY);
        validateMaximumValue(name, DESTINATION_MAX_LENGTH, ERROR_NAME_MAX_LENGTH);
        validateMinimumValue(name, DESTINATION_MIN_LENGTH, ERROR_NAME_MIN_LENGTH);
    }

    public static Destination valueOf(EntityDestination entity){
        Destination destination = new Destination();
        destination.setId(entity.getId());
        destination.setName(String.valueOf(entity.getName()));
        return destination;
    }

}
