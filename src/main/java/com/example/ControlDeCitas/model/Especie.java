package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "especie")
@Data
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecie")
    private Integer idEspecie;

    @Column(name = "nombreEspecie", nullable = false, length = 50)
    private String nombreEspecie;

}