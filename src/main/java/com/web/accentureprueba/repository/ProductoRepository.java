package com.web.accentureprueba.repository;

import com.web.accentureprueba.mapper.ProductoMaxStockMapper;
import com.web.accentureprueba.model.Producto;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {

    @Query("""
        SELECT
            s.id     AS sucursal_id,
            s.nombre AS sucursal,
            p.id     AS producto_id,
            p.nombre AS producto,
            p.stock  AS stock
        FROM sucursal s
        JOIN producto p
            ON p.sucursal_id = s.id
        JOIN (
            SELECT
                sucursal_id,
                MAX(stock) AS max_stock
            FROM producto
            GROUP BY sucursal_id
        ) max_p
            ON p.sucursal_id = max_p.sucursal_id
           AND p.stock = max_p.max_stock
        WHERE s.franquicia_id = :franquiciaId
        ORDER BY s.id
    """)
    Flux<ProductoMaxStockMapper> findProductoMaxStockFranquicia(Long franquiciaId);

}
