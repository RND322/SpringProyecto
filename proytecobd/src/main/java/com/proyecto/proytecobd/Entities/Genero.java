package com.proyecto.proytecobd.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "genero")
@Data
public class Genero {

    @Id
    @Column(name = "idgenero")
    private Long idGenero;

    @Column(name = "descripgenero",length = 15, nullable = false)
    private String descripGenero;
}
