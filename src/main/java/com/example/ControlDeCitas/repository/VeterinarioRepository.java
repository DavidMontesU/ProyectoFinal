package com.example.ControlDeCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Integer>{

}
