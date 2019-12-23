package com.ventas.ventadepasajes.infrastructure.entity;

import com.ventas.ventadepasajes.domain.model.entity.User;

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
    private String password;

    public EntityUser(){}

    public EntityUser(Long id, String name, String lastName, String email, String phone, long roleId, String password){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = roleId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

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
