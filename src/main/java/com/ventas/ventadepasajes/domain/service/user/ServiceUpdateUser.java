package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import com.ventas.ventadepasajes.domain.service.user.mapper.MapperUser;

public class ServiceUpdateUser {

    private RepositoryUser repositoryUser;

    public ServiceUpdateUser(RepositoryUser repositoryUser){
        this.repositoryUser = repositoryUser;
    }

    public DtoUser run(long id, User user){
        MapperUser mapper = new MapperUser();
        return mapper.entityToDto(this.repositoryUser.updateUser(id, user));
    }
}
