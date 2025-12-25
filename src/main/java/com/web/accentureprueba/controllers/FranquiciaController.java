package com.web.accentureprueba.controllers;

import com.web.accentureprueba.dto.ActualizarNombreDTO;
import com.web.accentureprueba.dto.FranquiciaDTO;
import com.web.accentureprueba.model.Franquicia;
import com.web.accentureprueba.repository.ProductoRepository;
import com.web.accentureprueba.repository.SucursalRepository;
import com.web.accentureprueba.service.FranquiciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    public FranquiciaController(FranquiciaService franquiciaService, SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
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

    @PutMapping("/{franquiciaId}/nombre")
    public Mono<ResponseEntity<Franquicia>> actualizarNombreFranquicia(@PathVariable Long franquiciaId, @RequestBody ActualizarNombreDTO actualizarNombreDTO){

        return franquiciaService.actualizarNombre(franquiciaId, actualizarNombreDTO)
                .map(ResponseEntity::ok);
    }

}
