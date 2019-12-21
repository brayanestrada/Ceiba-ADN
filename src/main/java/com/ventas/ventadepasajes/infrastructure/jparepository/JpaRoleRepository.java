package com.ventas.ventadepasajes.infrastructure.jparepository;

import com.ventas.ventadepasajes.infrastructure.entity.EntityRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoleRepository extends JpaRepository<EntityRole, Long> {

    @Query(value = "SELECT * FROM TBL_ROLE WHERE id = :id", nativeQuery = true)
    EntityRole searchRole(@Param("id") long id);
}
