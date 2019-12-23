package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.User;

public class DtoUser {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private long role;

    public DtoUser(){}

    public DtoUser(Long id, String name, String lastName, String email, String phone, long role){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public static DtoUser valueOf(User user){
        DtoUser dtoUser = new DtoUser();
        dtoUser.setId(user.getId());
        dtoUser.setName(user.getName());
        dtoUser.setLastName(user.getLastName());
        dtoUser.setEmail(user.getEmail());
        dtoUser.setPhone(user.getPhone());
        dtoUser.setRole(user.getRole());
        return dtoUser;
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
}

