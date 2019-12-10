package com.ventas.ventadepasajes.service;

import com.ventas.ventadepasajes.dto.UserDto;
import com.ventas.ventadepasajes.entity.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> findAll();

    public User saveUser(User user);

}
