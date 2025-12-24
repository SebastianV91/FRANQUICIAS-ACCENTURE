package com.web.accentureprueba.controllers;

import com.web.accentureprueba.dto.FranquiciaDTO;
import com.web.accentureprueba.dto.ProductoMaxStockDTO;
import com.web.accentureprueba.model.Franquicia;
import com.web.accentureprueba.repository.ProductoRepository;
import com.web.accentureprueba.repository.SucursalRepository;
import com.web.accentureprueba.service.FranquiciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaControllers {

    private final FranquiciaService franquiciaService;
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    public FranquiciaControllers(FranquiciaService franquiciaService, SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
        this.franquiciaService = franquiciaService;
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public Mono<ResponseEntity<Franquicia>> crear(@RequestBody FranquiciaDTO franquiciaDTO){

        return franquiciaService.crear(franquiciaDTO)
                .map(franquicia ->
                                ResponseEntity.status(HttpStatus.CREATED).body(franquicia));
    }

    @GetMapping("/{franquiciaId}/productos/max-stock")
    public Flux<ProductoMaxStockDTO> obtenerMaxStock(
            @PathVariable Long franquiciaId) {

        return franquiciaService.obtenerProductoMaxStock(
                franquiciaId,
                sucursalRepository,
                productoRepository);
    }

}
