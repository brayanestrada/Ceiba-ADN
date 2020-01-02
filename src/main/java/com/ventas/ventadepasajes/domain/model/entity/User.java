package com.ventas.ventadepasajes.domain.model.entity;

import static com.ventas.ventadepasajes.domain.model.entity.DataValidator.*;

public class User{

    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 30;
    private static final String LAST_NAME_IS_MANDATORY = "Last name is mandatory";
    private static final String EMAIL_IS_MANDATORY = "Email is mandatory";
    private static final String PHONE_IS_MANDATORY = "Phone is mandatory";
    private static final String MUST_HAVE_MIN = "must have min ";
    private static final String MUST_HAVE_MAX = "must have max ";
    private static final String CHARACTERS = " characters ";
    private static final String ROLE_ID_IS_MANDATORY = "Role is mandatory";
    private static final String PASS_IS_MANDATORY = "Password is mandatory";
    private static final String NAME_IS_MANDATORY = "Name is mandatory";
    private static final int NAME_MIN_LENGTH = 3;
    private static final int PHONE_MIN_LENGTH = 7;
    private static final int PHONE_MAX_LENGTH = 14;
    private static final String NUMBERS = " numbers";
    private static final int NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MIN_LENGTH = 3;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final String ERROR_NAME_MIN_LENGTH = "Name "+ MUST_HAVE_MIN + NAME_MIN_LENGTH + NUMBERS;
    private static final String ERROR_LAST_NAME_MIN_LENGTH = "Last name "+ MUST_HAVE_MIN + LAST_NAME_MIN_LENGTH + CHARACTERS;
    private static final String ERROR_LAST_NAME_MAX_LENGTH = "Last name" + MUST_HAVE_MAX + LAST_NAME_MAX_LENGTH + CHARACTERS;
    private static final String ERROR_PHONE_MIN_LENGTH = "Phone "+ MUST_HAVE_MIN + PHONE_MIN_LENGTH + NUMBERS;
    private static final String ERROR_PHONE_MAX_LENGTH = "Phone "+ MUST_HAVE_MAX + PHONE_MAX_LENGTH + NUMBERS;
    private static final String ERROR_NAME_MAX_LENGTH = "Name "+ MUST_HAVE_MAX + NAME_MAX_LENGTH + CHARACTERS;
    private static final String ERROR_PASS_MIN_LENGTH = "Password "+ MUST_HAVE_MIN + PASSWORD_MIN_LENGTH + CHARACTERS;
    private static final String ERROR_PASS_MAX_LENGTH = "Password " + MUST_HAVE_MAX + PASSWORD_MAX_LENGTH + CHARACTERS;

    private Long idModel;
    private String nameModel;
    private String lastNameModel;
    private String emailModel;
    private String phoneModel;
    private long roleModel;
    private String passwordModel;

    public User(Long id, String name, String lastName, String email, String phone, long role, String password){
        validate(name, lastName, email, phone, password, role);
        this.nameModel = name;
        this.phoneModel = phone;
        this.lastNameModel = lastName;
        this.emailModel = email;
        this.passwordModel = password;
        this.roleModel = role;
        this.idModel = id;
    }
    public User(String name, String lastName, String email, String phone, long role, String password){
        validate(name, lastName, email, phone, password, role);
        this.nameModel = name;
        this.lastNameModel = lastName;
        this.emailModel = email;
        this.phoneModel = phone;
        this.roleModel = role;
        this.passwordModel = password;
    }

    public Long getId() { return idModel; }

    public String getName() { return nameModel; }

    public String getLastName() { return lastNameModel; }

    public String getEmail() {
        return emailModel;
    }

    public String getPhone() {
        return phoneModel;
    }

    public long getRole() {
        return roleModel;
    }

    public String getPassword() {
        return passwordModel;
    }

    private void validate(String name, String lastName, String email, String phone, String password, long role){
        validateMandatory(name, NAME_IS_MANDATORY);
        validateMandatory(lastName, LAST_NAME_IS_MANDATORY);
        validateMandatory(email, EMAIL_IS_MANDATORY);
        validateMandatory(phone, PHONE_IS_MANDATORY);
        validateNumberMandatory(role, ROLE_ID_IS_MANDATORY);
        validateMandatory(password, PASS_IS_MANDATORY);
        validateMaximumValue(name, NAME_MAX_LENGTH, ERROR_NAME_MAX_LENGTH);
        validateMaximumValue(lastName, LAST_NAME_MAX_LENGTH, ERROR_LAST_NAME_MAX_LENGTH);
        validateMaximumValue(phone, PHONE_MAX_LENGTH, ERROR_PHONE_MAX_LENGTH);
        validateMaximumValue(password, PASSWORD_MAX_LENGTH, ERROR_PASS_MAX_LENGTH);
        validateMinimumValue(name, LAST_NAME_MIN_LENGTH, ERROR_NAME_MIN_LENGTH);
        validateMinimumValue(lastName, LAST_NAME_MIN_LENGTH, ERROR_LAST_NAME_MIN_LENGTH);
        validateMinimumValue(phone, PHONE_MIN_LENGTH, ERROR_PHONE_MIN_LENGTH);
        validateMinimumValue(password, PASSWORD_MIN_LENGTH, ERROR_PASS_MIN_LENGTH);
    }
}
