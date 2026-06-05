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
    private int idHistorial;

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

    @ManyToOne
    @JoinColumn(name = "idCita")
    private Cita cita;

}