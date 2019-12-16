package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.User;

public interface RepositoryUser {
    User createUser(User user);
}
