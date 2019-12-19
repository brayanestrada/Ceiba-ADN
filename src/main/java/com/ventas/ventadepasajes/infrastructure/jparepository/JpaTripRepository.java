package com.ventas.ventadepasajes.infrastructure.jparepository;

import com.ventas.ventadepasajes.infrastructure.entity.EntityTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTripRepository extends JpaRepository<EntityTrip, Long> {
}
