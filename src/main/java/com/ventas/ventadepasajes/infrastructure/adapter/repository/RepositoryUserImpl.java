package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper.MapperUser;
import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaUserRepository;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryUserImpl implements RepositoryUser {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaUserRepository jpaUserRepository;
    private Logger logger = LoggerFactory.getLogger(RepositoryUserImpl.class);

    public RepositoryUserImpl(JpaUserRepository jpaUserRepository){ this.jpaUserRepository = jpaUserRepository; }

    @Override
    public User createUser(User user) {
        EntityUser entityUser = modelMapper.map(user, EntityUser.class);
        entityUser = jpaUserRepository.save(entityUser);
        return new User(entityUser.getId(),entityUser.getName(), entityUser.getLastName(), entityUser.getEmail(), entityUser.getPhone(), entityUser.getRole(), user.getPassword());
    }

    @Override
    public List<User> listUser() {
        MapperUser mapperUser = new MapperUser();
        return mapperUser.entityToModelList(this.jpaUserRepository.findAll());
    }

    @Override
    public boolean deleteUser(long id) {
        try{
            this.jpaUserRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.info("Error deleting user");
            return false;
        }
    }

    @Override
    public User updateUser(long id, User newUser) {
        EntityUser entityUser = this.modelMapper.map(newUser, EntityUser.class);
        EntityUser entityUserUpdated = this.jpaUserRepository.findById(id)
                .map(user ->{
                    user.setId(newUser.getId());
                    user.setName(newUser.getName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setPhone(newUser.getPhone());
                    return jpaUserRepository.save(user);
                }).orElseGet(()->{
                    entityUser.setId(id);
                    entityUser.setName(newUser.getName());
                    entityUser.setLastName(newUser.getName());
                    entityUser.setEmail(newUser.getName());
                    entityUser.setPhone(newUser.getName());
                    return jpaUserRepository.save(entityUser);
                });
        return new User(entityUserUpdated.getId(), entityUserUpdated.getName(), entityUserUpdated.getLastName(), entityUserUpdated.getEmail(), entityUserUpdated.getPhone(), entityUserUpdated.getRole(), entityUserUpdated.getPassword());
    }

    @Override
    public User logIn(String email, String password) {
        EntityUser entityUser = this.jpaUserRepository.logIn(email, password);
        try{
            return this.modelMapper.map(entityUser, User.class);
        }catch (Exception e){
            throw new ExceptionGeneral("Incorrect user or password");
        }
    }
}
