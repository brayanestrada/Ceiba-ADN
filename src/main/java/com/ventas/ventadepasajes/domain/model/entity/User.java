package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;

import static com.ventas.ventadepasajes.domain.model.entity.DataValidator.*;

public class User{
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MIN_LENGTH = 3;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final String MUST_HAVE_MIN = "must have min";
    private static final String MUST_HAVE_MAX = "must have max";
    private static final String CHARACTERS = "characters";
    private static final String NAME_IS_MANDATORY = "Name is mandatory";
    private static final String LAST_NAME_IS_MANDATORY = "Last name is mandatory";
    private static final String ERROR_NAME_MIN_LENGTH = "Name "+ MUST_HAVE_MIN + NAME_MIN_LENGTH + CHARACTERS;
    private static final String ERROR_NAME_MAX_LENGTH = "Name "+ MUST_HAVE_MAX + NAME_MAX_LENGTH + CHARACTERS;
    private static final String ERROR_LAST_NAME_MIN_LENGTH = "Last name "+ MUST_HAVE_MIN + LAST_NAME_MIN_LENGTH + CHARACTERS;
    private static final String ERROR_LAST_NAME_MAX_LENGTH = "Last name" + MUST_HAVE_MAX + LAST_NAME_MAX_LENGTH + CHARACTERS;

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private long role;
    private String password;

    public User(){}

    public User(Long id, String name, String lastName, String email, String phone, long role, String password){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
        validate();
    }
    public User(String name, String lastName, String email, String phone, long role, String password){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
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

    private void validate(){
        validateMandatory(name, NAME_IS_MANDATORY);
        validateMandatory(lastName, LAST_NAME_IS_MANDATORY);
        validateMaximumValue(name, NAME_MAX_LENGTH, ERROR_NAME_MAX_LENGTH);
        validateMaximumValue(lastName, LAST_NAME_MAX_LENGTH, ERROR_LAST_NAME_MAX_LENGTH);
        validateMinimumValue(name, LAST_NAME_MIN_LENGTH, ERROR_NAME_MIN_LENGTH);
        validateMinimumValue(lastName, LAST_NAME_MIN_LENGTH, ERROR_LAST_NAME_MIN_LENGTH);
    }

    public static User valueOf(EntityUser entityUser){
        User userEntity = new User();
        userEntity.setId(entityUser.getId());
        userEntity.setName(entityUser.getName());
        userEntity.setLastName(entityUser.getLastName());
        userEntity.setEmail(entityUser.getEmail());
        userEntity.setPhone(entityUser.getPhone());
        userEntity.setRole(entityUser.getRole());
        userEntity.setPassword(entityUser.getPassword());
        return userEntity;
    }
}
