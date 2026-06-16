package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "veterinario")
@Data
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVet")
    private Integer idVet;

    @Column(name = "codVet", nullable = false, unique = true, length = 20)
    private String codVet;

    @Column(name = "nombreVet", nullable = false, length = 100)
    private String nombreVet;

    @Column(name = "codEsp")
    private String codEsp;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "edad")
    private int edad;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "nomEspecialidad", insertable = false, updatable = false)
    private String nomEspecialidad;
}