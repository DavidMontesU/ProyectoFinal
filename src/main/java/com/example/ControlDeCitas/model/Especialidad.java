package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "especialidad")
@Data
public class Especialidad {

    @Id
    @Column(name = "codEsp", length = 10)
    private String codEsp;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

}