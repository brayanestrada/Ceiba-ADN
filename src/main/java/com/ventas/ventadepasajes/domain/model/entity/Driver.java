package com.ventas.ventadepasajes.domain.model.entity;

public class Driver {

    private static final String LAST_NAME_IS_MANDATORY = "Last name is mandatory";
    private static final String IDENTIFICATION_IS_MANDATORY = "Identification is mandatory";
    private static final String MUST_HAVE_MIN = "must have min characters";
    private static final String MUST_HAVE_MAX = "must have max";
    private static final String NAME_IS_MANDATORY = "Name is mandatory";
    private static final int IDENTIFICATION_MIN_LENGTH = 8;
    private static final int IDENTIFICATION_MAX_LENGTH = 11;
    private static final int LAST_NAME_MIN_LENGTH = 2;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final String ERROR_LAST_NAME_MIN_LENGTH = "Last name "+ MUST_HAVE_MIN + LAST_NAME_MIN_LENGTH;
    private static final String ERROR_LAST_NAME_MAX_LENGTH = "Last name" + MUST_HAVE_MAX + LAST_NAME_MAX_LENGTH;
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 30;
    private static final String ERROR_NAME_MIN_LENGTH = "Name "+ MUST_HAVE_MIN + NAME_MIN_LENGTH;
    private static final String ERROR_NAME_MAX_LENGTH = "Name "+ MUST_HAVE_MAX + NAME_MAX_LENGTH;
    private static final String ERROR_IDENTIFICATION_MIN_LENGTH = "Identification "+ MUST_HAVE_MIN + IDENTIFICATION_MIN_LENGTH;
    private static final String ERROR_IDENTIFICATION_MAX_LENGTH = "Identification must have max " + IDENTIFICATION_MAX_LENGTH;

    private Long idModel;
    private String nameModel;
    private String lastNameModel;
    private String identificationModel;

    public Driver(Long id, String name, String lastName, String identification){
        dataValidatorDriver(name, lastName, identification);
        this.idModel = id;
        this.lastNameModel = lastName;
        this.nameModel = name;
        this.identificationModel = identification;
    }

    public Driver( String name, String lastName, String identification){
        dataValidatorDriver(name, lastName, identification);
        this.nameModel = name;
        this.lastNameModel = lastName;
        this.identificationModel = identification;
    }

    public Long getId() {
        return idModel;
    }

    public String getName() {
        return nameModel;
    }

    public String getLastName() {
        return lastNameModel;
    }

    public String getIdentification() {
        return identificationModel;
    }

    private void dataValidatorDriver(String name, String lastName, String identification){
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
}
