package com.example.ControlDeCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer>{

}
