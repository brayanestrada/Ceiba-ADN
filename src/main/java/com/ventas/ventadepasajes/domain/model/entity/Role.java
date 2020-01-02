package com.ventas.ventadepasajes.domain.model.entity;

public class Role {

    private static final int MIN_LENGTH_NAME = 2;
    private static final int MAX_LENGTH_NAME = 35;
    private static final String ERROR_NAME_MANDATORY = "Error: Name is mandatory";
    private static final String ERROR_NAME_LENGTH = "Error: Name characters must be between 2 and 35 characters";

    private long idModel;
    private String nameModel;

    public Role(long id, String name){
        validate(name);
        this.nameModel = name;
        this.idModel = id;
    }

    public Role(String name){
        validate(name);
        this.nameModel = name;
    }

    public long getId() {
        return idModel;
    }

    public String getName() {
        return nameModel;
    }

    private void validate(String name){
        DataValidator.validateMandatory( name, ERROR_NAME_MANDATORY );
        DataValidator.validateMinimumValue( name, MIN_LENGTH_NAME, ERROR_NAME_LENGTH );
        DataValidator.validateMaximumValue( name, MAX_LENGTH_NAME, ERROR_NAME_LENGTH );
    }
}
