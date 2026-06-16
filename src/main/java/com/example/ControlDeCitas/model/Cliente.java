package com.example.ControlDeCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name = "nombreCliente", nullable = false, length = 100)
    private String nombreCliente;

    @Column(name = "apellidoCliente", nullable = false, length = 100)
    private String apellidoCliente;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "correo", length = 100)
    private String correo;

}