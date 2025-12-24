package com.web.accentureprueba.service;

import com.web.accentureprueba.dto.ProductoDTO;
import com.web.accentureprueba.exception.NotFoundException;
import com.web.accentureprueba.model.Producto;
import com.web.accentureprueba.repository.ProductoRepository;
import com.web.accentureprueba.repository.SucursalRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;

    public ProductoService(ProductoRepository productoRepository, SucursalRepository sucursalRepository) {
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
    }

    public Mono<Producto> crear(Long sucursalId, ProductoDTO productoDTO){

        return sucursalRepository.findById(sucursalId)
                .switchIfEmpty(Mono.error(new NotFoundException("Sucursal no encontrada")))
                .flatMap(sucursal -> {
                    Producto producto = new Producto();
                    producto.setNombre(productoDTO.getNombre());
                    producto.setStock(productoDTO.getStock());
                    producto.setSucursalId(sucursalId);
                    return productoRepository.save(producto);
                });

    }

    public Mono<Void> eliminar(Long productoId) {

        return productoRepository.findById(productoId)
                .switchIfEmpty(Mono.error(
                        new NotFoundException("Producto no encontrado")))
                .flatMap(productoRepository::delete);

    }

}
