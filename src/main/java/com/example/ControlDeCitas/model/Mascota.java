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

    @ManyToOne
    @JoinColumn(name = "idEspecie")
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

}