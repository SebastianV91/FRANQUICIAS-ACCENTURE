package com.web.accentureprueba.controllers;

import com.web.accentureprueba.dto.FranquiciaDTO;
import com.web.accentureprueba.model.Franquicia;
import com.web.accentureprueba.service.FranquiciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaControllers {

    private final FranquiciaService franquiciaService;

    public FranquiciaControllers(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @PostMapping
    public Mono<ResponseEntity<Franquicia>> crear(@RequestBody FranquiciaDTO franquiciaDTO){

        return franquiciaService.crear(franquiciaDTO)
                .map(franquicia ->
                                ResponseEntity.status(HttpStatus.CREATED).body(franquicia));
    }

}
