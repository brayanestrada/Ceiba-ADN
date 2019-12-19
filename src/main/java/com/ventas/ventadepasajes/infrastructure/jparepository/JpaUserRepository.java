package com.ventas.ventadepasajes.infrastructure.jparepository;

import com.ventas.ventadepasajes.infrastructure.entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<EntityUser, Long> {

    @Query(value = "SELECT * FROM TBL_USER WHERE email = :email AND password = :password", nativeQuery = true)
    EntityUser logIn(@Param("email") String email,
                     @Param("password") String password);
}
