package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "clave", nullable = false, length = 255)
    private String clave;

    @Column(name = "idTipo")
    private Integer idTipo;
    
    @Column(name = "tipoUsuario", insertable = false, updatable = false)
    private String tipoUsuario;

}