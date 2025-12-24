package com.web.accentureprueba.controllers;

import com.web.accentureprueba.dto.ActualizarStockDTO;
import com.web.accentureprueba.dto.ProductoDTO;
import com.web.accentureprueba.model.Producto;
import com.web.accentureprueba.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sucursales/{sucursalId}/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Mono<ResponseEntity<Producto>> crear(@PathVariable Long sucursalId,
                                                @RequestBody ProductoDTO productoDTO){

        return productoService.crear(sucursalId, productoDTO)
                .map(producto -> ResponseEntity.status(HttpStatus.CREATED).body(producto));
    }

    @DeleteMapping("/{productoId}")
    public Mono<ResponseEntity<Void>> eliminar(@PathVariable Long productoId){

        return productoService.eliminar(productoId)
                .thenReturn(ResponseEntity.noContent().build());

    }

    @PutMapping("/{productoId}/stock")
    public Mono<ResponseEntity<Producto>> actualizarStock(
            @PathVariable Long productoId,
            @RequestBody ActualizarStockDTO actualizarStockDTO){

        return productoService.actualizarStock(productoId, actualizarStockDTO)
                .map(ResponseEntity::ok);
    }

}
