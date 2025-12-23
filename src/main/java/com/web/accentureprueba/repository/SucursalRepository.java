package com.web.accentureprueba.repository;

import com.web.accentureprueba.model.Sucursal;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SucursalRepository extends ReactiveCrudRepository<Sucursal, Long> {
}
