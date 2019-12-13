package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityDriver;

import static com.ventas.ventadepasajes.domain.model.entity.DataValidator.*;

public class Driver {

    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MIN_LENGTH = 2;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final int IDENTIFICATION_MIN_LENGTH = 8;
    private static final int IDENTIFICATION_MAX_LENGTH = 11;
    private static final String NAME_IS_MANDATORY = "Name is mandatory";
    private static final String LAST_NAME_IS_MANDATORY = "Last name is mandatory";
    private static final String IDENTIFICATION_IS_MANDATORY = "Identification is mandatory";
    private static final String ERROR_NAME_MIN_LENGTH = "Name must have min " + NAME_MIN_LENGTH + " characters";
    private static final String ERROR_NAME_MAX_LENGTH = "Name must have max " + NAME_MAX_LENGTH + " characters";
    private static final String ERROR_LAST_NAME_MIN_LENGTH = "Last name must have min " + LAST_NAME_MIN_LENGTH + " characters";
    private static final String ERROR_LAST_NAME_MAX_LENGTH = "Last name must have max " + LAST_NAME_MAX_LENGTH + " characters";
    private static final String ERROR_IDENTIFICATION_MIN_LENGTH = "Identification must have min " + IDENTIFICATION_MIN_LENGTH + " characters";
    private static final String ERROR_IDENTIFICATION_MAX_LENGTH = "Identification must have max " + IDENTIFICATION_MAX_LENGTH + " characters";

    private Long id;
    private String name;
    private String lastName;
    private String identification;

    public Driver(){}

    public Driver(Long id, String name, String lastName, String identification){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
        dataValidatorDriver();
    }

    public Driver( String name, String lastName, String identification){
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
        dataValidatorDriver();
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    private void dataValidatorDriver(){
        DataValidator.validateMandatory(name, NAME_IS_MANDATORY);
        DataValidator.validateMandatory(lastName, LAST_NAME_IS_MANDATORY);
        DataValidator.validateMandatory(identification, IDENTIFICATION_IS_MANDATORY);
        DataValidator.validateMaximumValue(name, NAME_MAX_LENGTH, ERROR_NAME_MAX_LENGTH);
        DataValidator.validateMinimumValue(name, NAME_MIN_LENGTH, ERROR_NAME_MIN_LENGTH);
        DataValidator.validateMaximumValue(lastName, LAST_NAME_MAX_LENGTH, ERROR_LAST_NAME_MAX_LENGTH);
        DataValidator.validateMinimumValue(lastName, LAST_NAME_MIN_LENGTH, ERROR_LAST_NAME_MIN_LENGTH);
        DataValidator.validateMaximumValue(identification, IDENTIFICATION_MAX_LENGTH, ERROR_IDENTIFICATION_MAX_LENGTH);
        DataValidator.validateMinimumValue(identification, IDENTIFICATION_MIN_LENGTH, ERROR_IDENTIFICATION_MIN_LENGTH);
    }

    public static Driver valueOf(EntityDriver entityDriver){
        Driver driver = new Driver();
        driver.setId(entityDriver.getId());
        driver.setName(entityDriver.getName());
        driver.setLastName(entityDriver.getLastName());
        driver.setIdentification(entityDriver.getIdentification());
        return driver;
    }

}
