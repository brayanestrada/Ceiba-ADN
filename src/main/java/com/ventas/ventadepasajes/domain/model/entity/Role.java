package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityRole;

public class Role {

    private long id;
    private String name;
    private static final int MIN_LENGTH_NAME = 2;
    private static final int MAX_LENGTH_NAME = 35;
    private static final String ERROR_NAME_MANDATORY = "Error: Name is mandatory";
    private static final String ERROR_NAME_LENGTH = "Error: Name characters must be between 2 and 35 characters";

    public Role(){}

    public Role(long id, String name){
        this.id = id;
        this.name = name;
        validate();
    }

    public Role(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Role valueOf(EntityRole entityRole){
        Role role = new Role();
        role.setId(entityRole.getId());
        role.setName(entityRole.getName());
        return role;
    }

    private void validate(){
        DataValidator.validateMandatory(name,ERROR_NAME_MANDATORY);
        DataValidator.validateMinimumValue(name, MIN_LENGTH_NAME, ERROR_NAME_LENGTH);
        DataValidator.validateMaximumValue(name, MAX_LENGTH_NAME, ERROR_NAME_LENGTH);
    }
}