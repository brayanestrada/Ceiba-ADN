package com.ventas.ventadepasajes.infrastructure.jparepository;

import com.ventas.ventadepasajes.infrastructure.entity.EntityDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaDriverRepository extends JpaRepository<EntityDriver, Long> {

    @Query(value = "SELECT * FROM TBL_DRIVER WHERE id = :id", nativeQuery = true)
    Optional<EntityDriver> searchDriver(@Param("id") long id);
}
