package com.web.accentureprueba.controllers;

import com.web.accentureprueba.dto.SucursalDTO;
import com.web.accentureprueba.model.Sucursal;
import com.web.accentureprueba.service.SucursalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franquicias/{franquiciaId}/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping
    public Mono<ResponseEntity<Sucursal>> crear(@PathVariable Long franquiciaId,
                                                @RequestBody SucursalDTO sucursalDTO){

        return sucursalService.crear(franquiciaId, sucursalDTO)
                .map(sucursal -> ResponseEntity.status(HttpStatus.CREATED).body(sucursal));
    }

}
