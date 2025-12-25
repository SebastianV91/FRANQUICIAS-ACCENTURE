package com.web.accentureprueba.controllers;

import com.web.accentureprueba.dto.ActualizarNombreDTO;
import com.web.accentureprueba.dto.SucursalDTO;
import com.web.accentureprueba.model.Sucursal;
import com.web.accentureprueba.service.SucursalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping("/{franquiciaId}")
    public Mono<ResponseEntity<Sucursal>> crear(@PathVariable Long franquiciaId,
                                                @RequestBody SucursalDTO sucursalDTO){

        return sucursalService.crear(franquiciaId, sucursalDTO)
                .map(sucursal -> ResponseEntity.status(HttpStatus.CREATED).body(sucursal));
    }

    @PutMapping("/{sucursalId}/nombre")
    public Mono<ResponseEntity<Sucursal>> actualizarNombreSucursal(@PathVariable Long sucursalId, @RequestBody ActualizarNombreDTO actualizarNombreDTO){

        return sucursalService.actualizarNombre(sucursalId, actualizarNombreDTO)
                .map(ResponseEntity::ok);
    }

}
