package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaUserRepository;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryUserImpl implements RepositoryUser {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaUserRepository jpaUserRepository;

    public RepositoryUserImpl(JpaUserRepository jpaUserRepository){ this.jpaUserRepository = jpaUserRepository; }

    @Override
    public User createUser(User user) {
        EntityUser entityUser = modelMapper.map(user, EntityUser.class);
        entityUser = jpaUserRepository.save(entityUser);
        return new User(entityUser.getId(),entityUser.getName(), entityUser.getLastName());
    }
}
