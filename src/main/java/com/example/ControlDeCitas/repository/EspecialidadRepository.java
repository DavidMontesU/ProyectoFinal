package com.example.ControlDeCitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {

	@Query(value = "CALL sp_listarEspecialidad()", nativeQuery = true)
	List<Especialidad> listarEspecialidades();
	
}
