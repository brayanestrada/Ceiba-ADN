package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;

public class ServiceCreateUser {

    private RepositoryUser repositoryUser;
    private RepositoryRole repositoryRole;

    public ServiceCreateUser(RepositoryUser repositoryUser, RepositoryRole repositoryRole){
        this.repositoryUser = repositoryUser;
        this.repositoryRole = repositoryRole;
    }

    public User run(User user){

        if (!roleExists(user.getRole())){
            throw new ExceptionGeneral("Error: Role didn't exist");
        }
        return this.repositoryUser.createUser(user);
    }

    private boolean roleExists(long id){
        return this.repositoryRole.searchRole(id);
    }
}
