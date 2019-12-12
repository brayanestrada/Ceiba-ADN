package com.ventas.ventadepasajes.infrastructure.port.repository;

import com.ventas.ventadepasajes.domain.model.User;
//TODO: poner puestos dentro de dominio
public interface RepositoryUser {
    void createUser(User user);
}
