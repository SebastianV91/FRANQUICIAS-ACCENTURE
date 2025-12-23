package com.web.accentureprueba.service;

import com.web.accentureprueba.dto.FranquiciaDTO;
import com.web.accentureprueba.exception.NotFoundException;
import com.web.accentureprueba.model.Franquicia;
import com.web.accentureprueba.repository.FranquiciaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public FranquiciaService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
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

}
