package com.example.ControlDeCitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Integer>{

	@Query(value = "CALL sp_listarVeterinario()", nativeQuery = true)
    List<Veterinario> listarVeterinarios();
}
