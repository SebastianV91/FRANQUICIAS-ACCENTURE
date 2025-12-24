package com.web.accentureprueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoMaxStockDTO {

    private String sucursal;
    private String producto;
    private Integer stock;

}
