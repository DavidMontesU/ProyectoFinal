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
    private Integer idCita;

    @Column(name = "idMascota")
    private Integer idMascota;

    @Column(name = "idVet")
    private Integer idVet;

    @Column(name = "idTipoServicio")
    private Integer idTipoServicio;

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

    @Column(name = "nombreMascota", insertable = false, updatable = false)
    private String nombreMascota;
    
    @Column(name = "nombreCliente", insertable = false, updatable = false)
    private String nombreCliente;
    
    @Column(name = "nombreVet", insertable = false, updatable = false)
    private String nombreVet;
    
    @Column(name = "tipoServicio", insertable = false, updatable = false)
    private String tipoServicio;

    @Column(name = "precio", insertable = false, updatable = false)
    private double precio;

}