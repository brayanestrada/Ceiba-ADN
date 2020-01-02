package com.ventas.ventadepasajes.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
public class EntityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private long role;
    @JsonIgnore
    private String password;

    private EntityUser(){}

    public EntityUser(Long id, String name, String lastName, String email, String phone, long roleId, String password){
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = roleId;
        this.email = email;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Long getIdEntity() {
        return id;
    }

    public String getNameEntity() {
        return name;
    }

    public String getLastNameEntity() {
        return lastName;
    }

    public void setIdEntity(Long id) { this.id = id; }

    public void setNameEntity(String name) { this.name = name; }

    public void setLastNameEntity(String lastName) { this.lastName = lastName; }

    public String getEmailEntity() {
        return email;
    }

    public void setEmailEntity(String email) {
        this.email = email;
    }

    public String getPhoneEntity() {
        return phone;
    }

    public void setPhoneEntity(String phone) {
        this.phone = phone;
    }

    public long getRoleEntity() {
        return role;
    }

    public void setRoleEntity(long role) {
        this.role = role;
    }

    public String getPasswordEntity() {
        return password;
    }

    public void setPasswordEntity(String password) {
        this.password = password;
    }
}
