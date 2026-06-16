package com.example.ControlDeCitas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(value = "CALL sp_listarCliente()", nativeQuery = true)
    List<Cliente> listarClientes();
	
	@Query(value = "CALL sp_obtenerCliente(:id)", nativeQuery = true)
	Optional<Cliente> obtenerCliente(@Param("id") Integer id);
	
	@Procedure(procedureName = "sp_actualizarCliente")
	void actualizarCliente(
			@Param("p_id") Integer id, 
			@Param("p_dni") String dni, 
			@Param("p_nombre") String nombre, 
			@Param("p_apellido") String apellido, 
			@Param("p_telf") String telf, 
			@Param("p_dir") String dir, 
			@Param("p_correo") String correo
	);
	
	
	@Procedure(procedureName = "sp_registrarCliente")
	void registrarCliente(
			@Param("p_dni") String dni, 
			@Param("p_nombre") String nombre, 
			@Param("p_apellido") String apellido, 
			@Param("p_telf") String telf, 
			@Param("p_dir") String dir, 
			@Param("p_correo") String correo
	);
	
	
	@Procedure(procedureName = "sp_eliminarCliente")
	void eliminarCliente(@Param("p_id") Integer id);
	
	
}
