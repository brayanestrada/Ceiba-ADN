package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import java.util.List;

public interface RepositoryRole {

    Role createRole(Role role);

    List<Role> listRole();

    boolean deleteRole(long id);

    Role updateRole(long id, Role role);

    boolean searchRole(long id);
}
