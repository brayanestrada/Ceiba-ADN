package com.ventas.ventadepasajes.infrastructure.jparepository;

import com.ventas.ventadepasajes.domain.model.User;
import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface JpaUserRepository extends JpaRepository<EntityUser, Serializable> {

}
