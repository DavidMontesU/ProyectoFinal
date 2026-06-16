package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tiposusuario")
@Data
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipo")
    private Integer idTipo;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

}