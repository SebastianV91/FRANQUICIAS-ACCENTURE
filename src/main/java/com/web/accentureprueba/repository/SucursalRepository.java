package com.web.accentureprueba.repository;

import com.web.accentureprueba.model.Sucursal;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SucursalRepository extends ReactiveCrudRepository<Sucursal, Long> {

    Flux<Sucursal> findByFranquiciaId(Long franquiciaId);

}
