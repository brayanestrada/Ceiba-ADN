package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;

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
    private String email;
    private String phone;

    public User(){}

    public User(Long id, String name, String lastName, String email, String phone){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        validate();
    }
    public User(String name, String lastName, String email, String phone){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        validate();
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

    private void validate(){
        validateMandatory(name, NAME_IS_MANDATORY);
        validateMaximumValue(name, NAME_MAX_LENGTH, ERROR_NAME_MAX_LENGTH);
        validateMinimumValue(name, LAST_NAME_MIN_LENGTH, ERROR_NAME_MIN_LENGTH);
        validateMandatory(lastName, LAST_NAME_IS_MANDATORY);
        validateMaximumValue(lastName, LAST_NAME_MAX_LENGTH, ERROR_LAST_NAME_MAX_LENGTH);
        validateMinimumValue(lastName, LAST_NAME_MIN_LENGTH, ERROR_LAST_NAME_MIN_LENGTH);
    }

    public static User valueOf(EntityUser entityUser){
        User user = new User();
        user.setId(entityUser.getId());
        user.setName(entityUser.getName());
        user.setLastName(entityUser.getLastName());
        user.setEmail(entityUser.getEmail());
        user.setPhone(entityUser.getPhone());
        return user;
    }
}
