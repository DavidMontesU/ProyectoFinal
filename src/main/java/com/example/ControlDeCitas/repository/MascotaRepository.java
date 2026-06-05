package com.example.ControlDeCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{

}
