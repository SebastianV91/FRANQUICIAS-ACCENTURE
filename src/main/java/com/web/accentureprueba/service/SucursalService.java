package com.web.accentureprueba.service;

import com.web.accentureprueba.dto.ActualizarNombreDTO;
import com.web.accentureprueba.dto.SucursalDTO;
import com.web.accentureprueba.exception.NotFoundException;
import com.web.accentureprueba.model.Sucursal;
import com.web.accentureprueba.repository.SucursalRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;
    private final FranquiciaService franquiciaService;

    public SucursalService(SucursalRepository sucursalRepository, FranquiciaService franquiciaService) {
        this.sucursalRepository = sucursalRepository;
        this.franquiciaService = franquiciaService;
    }

    public Mono<Sucursal> crear(Long franquiciaId, SucursalDTO sucursalDTO){
        return franquiciaService.obtenerPorId(franquiciaId)
                .flatMap(franquicia -> {
                    Sucursal sucursal = new Sucursal();
                    sucursal.setNombre(sucursalDTO.getNombre());
                    sucursal.setFranquiciaId(franquiciaId);
                    return sucursalRepository.save(sucursal);
                });
    }

    public Mono<Sucursal> actualizarNombre(Long sucursalId, ActualizarNombreDTO actualizarNombreDTO){

        return sucursalRepository.findById(sucursalId)
                .switchIfEmpty(Mono.error(
                        new NotFoundException("Sucursal no encontrada")))
                .flatMap(sucursal -> {
                    sucursal.setNombre(actualizarNombreDTO.getNombre());
                    return sucursalRepository.save(sucursal);
                });
    }

}
