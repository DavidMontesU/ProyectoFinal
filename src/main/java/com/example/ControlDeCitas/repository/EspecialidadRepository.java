package com.example.ControlDeCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, String>{

}
