package com.ventas.ventadepasajes.infrastructure.jparepository;

import com.ventas.ventadepasajes.infrastructure.entity.EntityTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTripRepository extends JpaRepository<EntityTrip, Long> {

    @Query(value = "SELECT * FROM TBL_TRIP WHERE id = :id", nativeQuery = true)
    EntityTrip searchTrip(@Param("id") long id);

}
