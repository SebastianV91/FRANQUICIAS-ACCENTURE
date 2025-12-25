package com.web.accentureprueba.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoMaxStockMapper {

    private Long sucursalId;
    private String sucursal;
    private Long productoId;
    private String producto;
    private Integer stock;

}
