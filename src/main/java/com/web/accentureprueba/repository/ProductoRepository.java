package com.web.accentureprueba.repository;

import com.web.accentureprueba.model.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {

    Flux<Producto> findBySucursalId(Long sucursalId);

}
