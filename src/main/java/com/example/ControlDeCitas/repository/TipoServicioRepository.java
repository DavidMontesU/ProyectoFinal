package com.example.ControlDeCitas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.TipoServicio;

@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer>{

	
	
	@Modifying
    @Transactional
    @Query(value = "CALL sp_eliminarTipoServicio(:idTipoServicio)", nativeQuery = true)
    void eliminarTipoServicio(
        @Param("idTipoServicio") Integer idTipoServicio
    );
	
	
	@Modifying
    @Transactional
    @Query(value = "CALL sp_actualizarTipoServicio(:descripcion, :precio, :idTipoServicio)", nativeQuery = true)
    void actualizarTipoServicio(
        @Param("descripcion") String descripcion, 
        @Param("precio") Double precio, // O BigDecimal si usas ese tipo de dato
        @Param("idTipoServicio") Integer idTipoServicio
    );
	
	
	@Query(value = "CALL sp_obtenerTipoServicioPorId(:idTipoServicio)", nativeQuery = true)
    Optional<TipoServicio> obtenerTipoServicioPorId(
        @Param("idTipoServicio") Integer idTipoServicio
    );
	
	
	@Modifying
    @Transactional
    @Query(value = "CALL sp_insertarTipoServicio(:descripcion, :precio)", nativeQuery = true)
    void registrarTipoServicio(
        @Param("descripcion") String descripcion, 
        @Param("precio") Double precio // Usa BigDecimal si prefieres mayor precisión financiera
    );
	
	
	@Query(value = "CALL sp_listarTipoServicio()", nativeQuery = true)
    List<TipoServicio> listarTiposServicios();
}
