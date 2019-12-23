package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;

import static com.ventas.ventadepasajes.domain.model.entity.DataValidator.*;

public class User{
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MIN_LENGTH = 3;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final int PHONE_MIN_LENGTH = 7;
    private static final int PHONE_MAX_LENGTH = 14;
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 30;
    private static final String MUST_HAVE_MIN = "must have min ";
    private static final String MUST_HAVE_MAX = "must have max ";
    private static final String CHARACTERS = " characters ";
    private static final String NAME_IS_MANDATORY = "Name is mandatory";
    private static final String LAST_NAME_IS_MANDATORY = "Last name is mandatory";
    private static final String EMAIL_IS_MANDATORY = "Email is mandatory";
    private static final String PHONE_IS_MANDATORY = "Phone is mandatory";
    private static final String ROLE_ID_IS_MANDATORY = "Role is mandatory";
    private static final String PASSWORD_IS_MANDATORY = "Password is mandatory";
    private static final String ERROR_NAME_MIN_LENGTH = "Name "+ MUST_HAVE_MIN + NAME_MIN_LENGTH + " numbers";
    private static final String ERROR_PHONE_MIN_LENGTH = "Phone "+ MUST_HAVE_MIN + PHONE_MAX_LENGTH + " numbers";
    private static final String ERROR_PHONE_MAX_LENGTH = "Phone "+ MUST_HAVE_MIN + PHONE_MAX_LENGTH + " numbers";
    private static final String ERROR_NAME_MAX_LENGTH = "Name "+ MUST_HAVE_MAX + NAME_MAX_LENGTH + CHARACTERS;
    private static final String ERROR_LAST_NAME_MIN_LENGTH = "Last name "+ MUST_HAVE_MIN + LAST_NAME_MIN_LENGTH + CHARACTERS;
    private static final String ERROR_LAST_NAME_MAX_LENGTH = "Last name" + MUST_HAVE_MAX + LAST_NAME_MAX_LENGTH + CHARACTERS;
    private static final String ERROR_PASSWORD_MIN_LENGTH = "Password "+ MUST_HAVE_MIN + PASSWORD_MIN_LENGTH + CHARACTERS;
    private static final String ERROR_PASSWORD_MAX_LENGTH = "Password " + MUST_HAVE_MAX + PASSWORD_MAX_LENGTH + CHARACTERS;

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private long role;
    private String password;

    public User(){}

    public User(Long id, String name, String lastName, String email, String phone, long role, String password){
        validate(name, lastName, email, phone, password, role);
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }
    public User(String name, String lastName, String email, String phone, long role, String password){
        validate(name, lastName, email, phone, password, role);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void validate(String name, String lastName, String email, String phone, String password, long role){
        validateMandatory(name, NAME_IS_MANDATORY);
        validateMandatory(lastName, LAST_NAME_IS_MANDATORY);
        validateMandatory(email, EMAIL_IS_MANDATORY);
        validateMandatory(phone, PHONE_IS_MANDATORY);
        validateNumberMandatory(role, ROLE_ID_IS_MANDATORY);
        validateMandatory(password, PASSWORD_IS_MANDATORY);
        validateMaximumValue(name, NAME_MAX_LENGTH, ERROR_NAME_MAX_LENGTH);
        validateMaximumValue(lastName, LAST_NAME_MAX_LENGTH, ERROR_LAST_NAME_MAX_LENGTH);
        validateMaximumValue(phone, PHONE_MAX_LENGTH, ERROR_PHONE_MAX_LENGTH);
        validateMaximumValue(password, PASSWORD_MAX_LENGTH, ERROR_PASSWORD_MAX_LENGTH);
        validateMinimumValue(name, LAST_NAME_MIN_LENGTH, ERROR_NAME_MIN_LENGTH);
        validateMinimumValue(lastName, LAST_NAME_MIN_LENGTH, ERROR_LAST_NAME_MIN_LENGTH);
        validateMinimumValue(phone, PHONE_MIN_LENGTH, ERROR_PHONE_MIN_LENGTH);
        validateMinimumValue(password, PASSWORD_MIN_LENGTH, ERROR_PASSWORD_MIN_LENGTH);
    }
}
