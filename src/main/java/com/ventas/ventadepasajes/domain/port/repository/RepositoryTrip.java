package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.Trip;

import java.util.List;

public interface RepositoryTrip {

    Trip createTrip(Trip trip);

    List<Trip> listTrip();

    boolean deleteTrip(long id);

    Trip updateTrip(long id, Trip trip);

    Trip searchTrip(long id);
}
