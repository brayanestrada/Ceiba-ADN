package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.model.User;
import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaUserRepository;
import com.ventas.ventadepasajes.port.repository.RepositoryUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryUserImpl implements RepositoryUser {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaUserRepository jpaUserRepository;

    public RepositoryUserImpl(JpaUserRepository jpaUserRepository){
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void createUser(User user) {
        EntityUser entityUser = modelMapper.map(user, EntityUser.class);
        jpaUserRepository.save(entityUser);
    }
}
