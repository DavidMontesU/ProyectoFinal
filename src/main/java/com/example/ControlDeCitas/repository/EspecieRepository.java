package com.example.ControlDeCitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {

	@Query(value = "CALL sp_listarEspecie()", nativeQuery = true)
	List<Especie> listarEspecies();
	
}
