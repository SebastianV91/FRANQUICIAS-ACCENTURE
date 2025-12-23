package com.web.accentureprueba.repository;

import com.web.accentureprueba.model.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {
}
