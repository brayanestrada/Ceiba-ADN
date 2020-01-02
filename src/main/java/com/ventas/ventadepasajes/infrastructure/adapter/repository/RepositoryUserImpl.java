package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper.MapperUser;
import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaUserRepository;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryUserImpl implements RepositoryUser {

    private JpaUserRepository jpaUserRepository;
    private Logger logger = LoggerFactory.getLogger(RepositoryUserImpl.class);
    private MapperUser mapperUser = new MapperUser();

    public RepositoryUserImpl(JpaUserRepository jpaUserRepository){ this.jpaUserRepository = jpaUserRepository; }

    @Override
    public User createUser(User user) {
        EntityUser entityUser = jpaUserRepository.save(mapperUser.modelToEntity(user));
        return new User(entityUser.getIdEntity(),entityUser.getNameEntity(), entityUser.getLastNameEntity(), entityUser.getEmailEntity(), entityUser.getPhoneEntity(), entityUser.getRoleEntity(), user.getPassword());
    }

    @Override
    public List<User> listUser() {
        return this.mapperUser.entityToModelList(this.jpaUserRepository.findAll());
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
        EntityUser entityUser = this.mapperUser.modelToEntity(newUser);
        EntityUser entityUserUpdated = this.jpaUserRepository.findById(id)
                .map(user ->{
                    user.setIdEntity(newUser.getId());
                    user.setNameEntity(newUser.getName());
                    user.setLastNameEntity(newUser.getLastName());
                    user.setEmailEntity(newUser.getEmail());
                    user.setPhoneEntity(newUser.getPhone());
                    return jpaUserRepository.save(user);
                }).orElseGet(()->{
                    entityUser.setIdEntity(id);
                    entityUser.setNameEntity(newUser.getName());
                    entityUser.setLastNameEntity(newUser.getName());
                    entityUser.setEmailEntity(newUser.getName());
                    entityUser.setPhoneEntity(newUser.getName());
                    return jpaUserRepository.save(entityUser);
                });
        return new User(entityUserUpdated.getIdEntity(), entityUserUpdated.getNameEntity(), entityUserUpdated.getLastNameEntity(), entityUserUpdated.getEmailEntity(), entityUserUpdated.getPhoneEntity(), entityUserUpdated.getRoleEntity(), entityUserUpdated.getPasswordEntity());
    }

    @Override
    public User logIn(String email, String password) {
        EntityUser entityUser = this.jpaUserRepository.logIn(email, password);
        try{
            return this.mapperUser.entityToModel(entityUser);
        }catch (Exception e){
            throw new ExceptionGeneral("Incorrect user or password");
        }
    }
}
