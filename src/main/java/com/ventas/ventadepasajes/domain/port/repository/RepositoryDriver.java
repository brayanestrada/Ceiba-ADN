package com.ventas.ventadepasajes.domain.port.repository;

import com.ventas.ventadepasajes.domain.model.entity.Driver;

import java.util.List;

public interface RepositoryDriver {
    Driver createDriver(Driver driver);

    List<Driver> listDriver();
}
