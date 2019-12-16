package com.ventas.ventadepasajes.domain.service.user;

import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import com.ventas.ventadepasajes.domain.service.user.mapper.MapperUser;

import java.util.List;

public class ServiceListUser {

    private RepositoryUser repositoryUser;

    public ServiceListUser(RepositoryUser repositoryUser){this.repositoryUser = repositoryUser;}

    public List<DtoUser> run(){
        MapperUser mapperUser = new MapperUser();
        List<User> listUser = this.repositoryUser.listUser();
        return mapperUser.entityListToDtoList(listUser);
    }
}
