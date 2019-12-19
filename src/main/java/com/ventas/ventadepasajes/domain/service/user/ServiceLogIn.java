package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import com.ventas.ventadepasajes.domain.service.user.mapper.MapperUser;

public class ServiceLogIn {

    private RepositoryUser repositoryUser;

    public ServiceLogIn(RepositoryUser repositoryUser){
        this.repositoryUser = repositoryUser;
    }

    public DtoUser run(String email, String password){
        MapperUser mapperUser = new MapperUser();
        return mapperUser.entityToDto(this.repositoryUser.logIn(email, password));
    }
}
