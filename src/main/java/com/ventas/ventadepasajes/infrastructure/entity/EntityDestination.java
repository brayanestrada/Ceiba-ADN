package com.ventas.ventadepasajes.infrastructure.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_destination")
public class EntityDestination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public EntityDestination(){}

    public EntityDestination(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }
}