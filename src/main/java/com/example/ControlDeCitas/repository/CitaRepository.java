package com.example.ControlDeCitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{
	
	@Query(value = "CALL sp_listarCita()", nativeQuery = true)
    List<Cita> llamarSpListarCitas();

	@Procedure(procedureName = "sp_actualizarCita")
    void actualizarCita(
            @Param("p_id") Integer idCita,
            @Param("p_idMascota") Integer idMascota,
            @Param("p_idVet") Integer idVet,
            @Param("p_idTipoServicio") Integer idTipoServicio,
            @Param("p_fecha") String fechaCita,
            @Param("p_hora") String horaCita,
            @Param("p_motivo") String motivo,
            @Param("p_estado") String estado,
            @Param("p_obs") String observaciones
    );
	
	@Procedure(procedureName = "sp_registrarCita")
    void registrarCita(
        @Param("p_idMascota") Integer idMascota, 
        @Param("p_idVet") Integer idVet, 
        @Param("p_idTipoServicio") Integer idTipoServicio, 
        @Param("p_fecha") String fecha, 
        @Param("p_hora") String hora, 
        @Param("p_motivo") String motivo, 
        @Param("p_obs") String obs
    );
	
	@Procedure(procedureName = "sp_obtenerCita")
    Cita obtenerCita(@Param("p_id") Integer id);

	@Procedure(procedureName = "sp_eliminarCita")
    void eliminarCita(@Param("p_id") Integer id);
	
	@Procedure(procedureName = "sp_buscarCitaByFecha")
    List<Cita> buscarCitaPorFecha(@Param("p_fecha") String fecha);
	
}
