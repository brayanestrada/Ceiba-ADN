package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import com.ventas.ventadepasajes.domain.service.user.mapper.MapperUser;

public class ServiceCreateUser {

    private RepositoryUser repositoryUser;

    public ServiceCreateUser(RepositoryUser repositoryUser){
        this.repositoryUser = repositoryUser;
    }

    public DtoUser run(User user){
        MapperUser mapperUser = new MapperUser();
        return mapperUser.entityToDto(this.repositoryUser.createUser(user));
    }
}
