package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.User;

import java.util.List;

public interface RepositoryUser {
    User createUser(User user);

    List<User> listUser();

    boolean deleteUser(long id);

    User updateUser(long id, User user);

    User logIn(String email, String password);
}
