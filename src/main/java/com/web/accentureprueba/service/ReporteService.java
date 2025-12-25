package com.web.accentureprueba.service;

import com.web.accentureprueba.dto.ProductoMaxStockDTO;
import com.web.accentureprueba.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ReporteService {

    private final ProductoRepository productoRepository;

    public ReporteService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Flux<ProductoMaxStockDTO> obtenerMaxStockFranquicia(Long franquiciaId){

        return productoRepository
                .findProductoMaxStockFranquicia(franquiciaId)
                .map(view -> new ProductoMaxStockDTO(
                        view.getSucursal(),
                        view.getProducto(),
                        view.getStock()
                ));

    }

}
