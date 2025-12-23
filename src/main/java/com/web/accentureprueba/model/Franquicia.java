package com.web.accentureprueba.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("franquicia")
@Data
public class Franquicia {

    @Id
    private Long Id;
    private String nombre;

}
