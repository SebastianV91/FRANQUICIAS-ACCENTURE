package com.web.accentureprueba.service;

import com.web.accentureprueba.dto.FranquiciaDTO;
import com.web.accentureprueba.dto.ProductoMaxStockDTO;
import com.web.accentureprueba.exception.NotFoundException;
import com.web.accentureprueba.model.Franquicia;
import com.web.accentureprueba.model.Producto;
import com.web.accentureprueba.repository.FranquiciaRepository;
import com.web.accentureprueba.repository.ProductoRepository;
import com.web.accentureprueba.repository.SucursalRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    public FranquiciaService(FranquiciaRepository franquiciaRepository, SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
    }

    public Mono<Franquicia> crear(FranquiciaDTO franquiciaDTO){
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(franquiciaDTO.getNombre());
        return franquiciaRepository.save(franquicia);
    }

    public Mono<Franquicia> obtenerPorId(Long id){
        return franquiciaRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Franquicia no encontrada")));
    }

    public Flux<ProductoMaxStockDTO> obtenerProductoMaxStock(
            Long franquiciaId,
            SucursalRepository sucursalRepository,
            ProductoRepository productoRepository){

        return sucursalRepository.findByFranquiciaId(franquiciaId)
                .switchIfEmpty(Mono.error(
                        new NotFoundException("Franquicia sin sucursales")))
                .flatMap(sucursal ->
                        productoRepository.findBySucursalId(sucursal.getId())
                                .sort(Comparator.comparing(Producto::getStock).reversed())
                                .next()
                                .map(producto -> new ProductoMaxStockDTO(
                                                                sucursal.getNombre(),
                                                                producto.getNombre(),
                                                                producto.getStock()
                                ))
                );

    }

}
