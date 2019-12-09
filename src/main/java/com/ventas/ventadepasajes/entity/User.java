package com.ventas.ventadepasajes.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String lastName;
    private String password;
}
