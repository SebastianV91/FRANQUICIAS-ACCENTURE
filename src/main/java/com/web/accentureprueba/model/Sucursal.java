package com.web.accentureprueba.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("sucursal")
@Data
public class Sucursal {

    @Id
    private Long id;
    private String nombre;
    private Long franquiciaId;



}
