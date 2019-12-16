package com.ventas.ventadepasajes.domain.model.entity;

import static com.ventas.ventadepasajes.domain.model.entity.DataValidator.*;

public class User{
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MIN_LENGTH = 3;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final String NAME_IS_MANDATORY = "Name is mandatory";
    private static final String LAST_NAME_IS_MANDATORY = "Name is mandatory";
    private static final String ERROR_NAME_MIN_LENGTH = "Name must have min " + NAME_MIN_LENGTH + " characters";
    private static final String ERROR_NAME_MAX_LENGTH = "Name must have max " + LAST_NAME_MAX_LENGTH + " characters";
    private static final String ERROR_LAST_NAME_MIN_LENGTH = "Name must have max " + LAST_NAME_MAX_LENGTH + " characters";
    private static final String ERROR_LAST_NAME_MAX_LENGTH = "Name must have max " + LAST_NAME_MAX_LENGTH + " characters";

    private Long id;
    private String name;
    private String lastName;

    public User(Long id, String name, String lastName){
        validate();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    public User(String name, String lastName){
        validate();
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    private void validate(){
        validateMandatory(name, NAME_IS_MANDATORY);
        validateMaximumValue(name, NAME_MAX_LENGTH, ERROR_NAME_MAX_LENGTH);
        validateMinimumValue(name, LAST_NAME_MIN_LENGTH, ERROR_NAME_MIN_LENGTH);
        validateMandatory(lastName, LAST_NAME_IS_MANDATORY);
        validateMaximumValue(lastName, LAST_NAME_MAX_LENGTH, ERROR_LAST_NAME_MAX_LENGTH);
        validateMinimumValue(lastName, LAST_NAME_MIN_LENGTH, ERROR_LAST_NAME_MIN_LENGTH);
    }
}
