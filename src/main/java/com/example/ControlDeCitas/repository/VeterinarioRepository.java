package com.example.ControlDeCitas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

	// --- LECTURAS ---
	
	@Query(value = "CALL sp_listarVeterinario()", nativeQuery = true)
	List<Veterinario> listarVeterinarios();
	
	@Query(value = "CALL sp_obtenerVeterinario(:id)", nativeQuery = true)
	Optional<Veterinario> obtenerVeterinarioPorId(@Param("id") Integer id);
	
	
	@Query(value = "CALL sp_buscarVeterinarioByNombre(:nombre)", nativeQuery = true)
	List<Veterinario> buscarVeterinariosPorNombre(@Param("nombre") String nombre);

	// --- ESCRITURAS ---
	
	@Procedure(procedureName = "sp_registrarVeterinario")
	void registrarVeterinario(
			@Param("p_codVet") String codVet,
			@Param("p_nomVet") String nomVet,
			@Param("p_codEsp") String codEsp,
			@Param("p_telf") String telf,
			@Param("p_edad") Integer edad,
			@Param("p_correo") String correo
	);
	
	
	@Procedure(procedureName = "sp_actualizarVeterinario")
	void actualizarVeterinario(
			@Param("p_id") Integer id,
			@Param("p_codVet") String codVet,
			@Param("p_nomVet") String nomVet,
			@Param("p_codEsp") String codEsp,
			@Param("p_telf") String telf,
			@Param("p_edad") Integer edad,
			@Param("p_correo") String correo
	);
	
	@Procedure(procedureName = "sp_eliminarVeterinario")
	void eliminarVeterinario(@Param("p_id") Integer id);
	
}