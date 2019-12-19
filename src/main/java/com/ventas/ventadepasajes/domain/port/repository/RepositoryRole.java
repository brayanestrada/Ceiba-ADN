package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RepositoryRole {

    Role createRole(Role role);

    List<Role> listRole();

    boolean deleteRole(long id);

    Role updateRole(long id, Role role);

    Role searchRole(long id);
}
