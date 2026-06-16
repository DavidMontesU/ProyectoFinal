package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "historialclinico")
@Data
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorial")
    private Integer idHistorial;

    @Column(name = "diagnostico", nullable = false, length = 500)
    private String diagnostico;

    @Column(name = "tratamiento", length = 500)
    private String tratamiento;

    @Column(name = "receta", length = 500)
    private String receta;

    @Column(name = "proximaCita")
    private String proximaCita;

    @Column(name = "fechaRegistro")
    private String fechaRegistro;

    @Column(name = "idCita")
    private Integer idCita;

    
    @Column(name = "fechaCita", insertable = false, updatable = false)
    private String fechaCita;
    
    @Column(name = "horaCita", insertable = false, updatable = false)
    private String horaCita;
    
    @Column(name = "motivo", insertable = false, updatable = false)
    private String motivo;
    
    @Column(name = "nombreVet", insertable = false, updatable = false)
    private String nombreVet;
    
    @Column(name = "tipoServicio", insertable = false, updatable = false)
    private String tipoServicio;
}