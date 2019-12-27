package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.Driver;

import java.util.List;

public interface RepositoryDriver {

    Driver createDriver(Driver driver);

    List<Driver> listDriver();

    boolean deleteDriver(Long id);

    Driver updateDriver(Long id, Driver driver);

    boolean searchDriver(Long id);
}
