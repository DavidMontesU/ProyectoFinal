package com.example.ControlDeCitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ControlDeCitas.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(value = "CALL sp_listarCliente()", nativeQuery = true)
    List<Cliente> listarClientes();
}
