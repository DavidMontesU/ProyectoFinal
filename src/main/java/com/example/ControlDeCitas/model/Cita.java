package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cita")
@Data
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private int idCita;

    @Column(name = "idMascota")
    private int idMascota;

    @Column(name = "idVet")
    private int idVet;

    @Column(name = "idTipoServicio")
    private int idTipoServicio;

    @Column(name = "fechaCita")
    private String fechaCita;

    @Column(name = "horaCita")
    private String horaCita;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones")
    private String observaciones;

    @Transient
    private String nombreMascota;
    
    @Transient
    private String nombreCliente;
    
    @Transient
    private String nombreVet;
    
    @Transient
    private String tipoServicio;

    @Transient
    private double precio;

}