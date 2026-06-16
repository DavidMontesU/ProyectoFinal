package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mascota")
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascota")
    private int idMascota;

    @Column(name = "nombreMascota", nullable = false, length = 100)
    private String nombreMascota;

    @Column(name = "raza", length = 100)
    private String raza;

    @Column(name = "edad")
    private int edad;

    @Column(name = "peso")
    private double peso;

    @Column(name = "observaciones", length = 500)
    private String observaciones;

    @Column(name = "idEspecie")
    private Integer idEspecie;

    @Column(name = "idCliente")
    private Integer idCliente;
    
    @Column(name = "nombreEspecie", insertable = false, updatable = false)
    private String nombreEspecie;

    @Column(name = "nombreDueno", insertable = false, updatable = false)
    private String nombreDueno;

}