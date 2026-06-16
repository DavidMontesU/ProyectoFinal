package com.example.ControlDeCitas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "CALL sp_validarUsuario(:username, :clave)", nativeQuery = true)
    List<Usuario> validarUsuario(
        @Param("username") String username, 
        @Param("clave") String clave
    );
	
	
	@Modifying
    @Transactional
    @Query(value = "CALL sp_eliminarUsuario(:idUsuario)", nativeQuery = true)
    void eliminarUsuario(
        @Param("idUsuario") Long idUsuario
    );
	
	
	@Modifying
    @Transactional
    @Query(value = "CALL sp_actualizarUsuario(:username, :clave, :idTipo, :idUsuario)", nativeQuery = true)
    void actualizarUsuario(
        @Param("username") String username, 
        @Param("clave") String clave, 
        @Param("idTipo") Integer idTipo,
        @Param("idUsuario") Long idUsuario
    );
	
	
	@Query(value = "CALL sp_obtenerUsuarioPorId(:idUsuario)", nativeQuery = true)
    Optional<Usuario> obtenerUsuarioPorId(
        @Param("idUsuario") Long idUsuario
    );
	
	
	@Modifying
    @Transactional
    @Query(value = "CALL sp_insertarUsuario(:username, :clave, :idTipo)", nativeQuery = true)
    void registrarUsuario(
        @Param("username") String username, 
        @Param("clave") String clave, 
        @Param("idTipo") Integer idTipo
    );
	
	
	@Query(value = "CALL sp_obtenerUsuariosConTipo()", nativeQuery = true)
	List<Usuario> obtenerTodosLosUsuarios();
}
