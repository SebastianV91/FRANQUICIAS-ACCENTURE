package com.web.accentureprueba.controllers;

import com.web.accentureprueba.dto.ProductoMaxStockDTO;
import com.web.accentureprueba.service.ReporteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/reporte")
public class ReporteController {

    private ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/{franquiciaId}/productos/max-stock")
    public Flux<ProductoMaxStockDTO> obtenerMaxStock(@PathVariable Long franquiciaId){

        return reporteService.obtenerMaxStockFranquicia(franquiciaId);
    }

}
