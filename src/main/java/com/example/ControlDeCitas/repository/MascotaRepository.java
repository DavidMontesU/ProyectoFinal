package com.example.ControlDeCitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{

	@Query(value = "CALL sp_listarMascota()", nativeQuery = true)
    List<Mascota> listarMascotas();

	@Query(value = "CALL sp_obtenerMascota(:p_id)", nativeQuery = true)
	Mascota obtenerMascota(@Param("p_id") Integer p_id);

	@Procedure(procedureName = "sp_registrarMascota")
	void registrarMascota(
		@Param("p_nombre") String p_nombre,
		@Param("p_idEspecie") Integer p_idEspecie,
		@Param("p_raza") String p_raza,
		@Param("p_edad") Integer p_edad,
		@Param("p_peso") Double p_peso,
		@Param("p_idCliente") Integer p_idCliente,
		@Param("p_obs") String p_obs
	);

	@Procedure(procedureName = "sp_actualizarMascota")
	void actualizarMascota(
		@Param("p_id") Integer p_id,
		@Param("p_nombre") String p_nombre,
		@Param("p_idEspecie") Integer p_idEspecie,
		@Param("p_raza") String p_raza,
		@Param("p_edad") Integer p_edad,
		@Param("p_peso") Double p_peso,
		@Param("p_idCliente") Integer p_idCliente,
		@Param("p_obs") String p_obs
	);

	@Procedure(procedureName = "sp_eliminarMascota")
	void eliminarMascota(@Param("p_id") Integer p_id);

	@Query(value = "CALL sp_buscarMascotaByNombre(:p_nombre)", nativeQuery = true)
	List<Mascota> buscarMascotaByNombre(@Param("p_nombre") String p_nombre);
}
