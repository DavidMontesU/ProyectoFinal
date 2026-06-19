package com.example.ControlDeCitas.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.HistorialClinico;

@Repository
public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Integer>{
	
	@Query(value = "SELECT h.idHistorial, h.idCita, h.diagnostico, h.tratamiento, " +
			"h.receta, h.proximaCita, h.fechaRegistro, " +
			"c.fechaCita, c.horaCita, c.motivo, " +
			"v.nombreVet, ts.descripcion AS tipoServicio " +
			"FROM historialclinico h " +
			"INNER JOIN cita c ON h.idCita = c.idCita " +
			"INNER JOIN veterinario v ON c.idVet = v.idVet " +
			"INNER JOIN tiposervicio ts ON c.idTipoServicio = ts.idTipoServicio " +
			"WHERE h.idHistorial = :idHistorial", nativeQuery = true)
	Optional<HistorialClinico> obtenerHistorialPorId(@Param("idHistorial") Integer idHistorial);
	
	@Query(value = "CALL sp_obtenerHistorialByMascota(:idMascota)", nativeQuery = true)
	List<HistorialClinico> obtenerHistorialPorMascota(@Param("idMascota") Integer idMascota);

	@Procedure(procedureName = "sp_registrarHistorial")
	void registrarHistorial(
			@Param("p_idCita") Integer idCita,
			@Param("p_diagnostico") String diagnostico,
			@Param("p_tratamiento") String tratamiento,
			@Param("p_receta") String receta,
			@Param("p_proximaCita") String proximaCita
	);
	
	
	
}
