package com.ventas.ventadepasajes.infrastructure.jparepository;

import com.ventas.ventadepasajes.infrastructure.entity.EntityDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDriverRepository extends JpaRepository<EntityDriver, Long> {
}
