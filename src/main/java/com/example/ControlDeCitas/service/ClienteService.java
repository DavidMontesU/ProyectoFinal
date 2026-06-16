package com.example.ControlDeCitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.Cliente;
import com.example.ControlDeCitas.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	// --- LECTURAS ---
	
	@Transactional(readOnly = true)
	public List<Cliente> listarTodos() {
		return repo.listarClientes();
	}
	
	@Transactional(readOnly = true)
	public Optional<Cliente> obtenerPorId(Integer id) {
		return repo.obtenerCliente(id);
	}
	
	// --- ESCRITURAS ---
	
	@Transactional
	public void registrarCliente(Cliente cliente) {
		repo.registrarCliente(
				cliente.getDni(), 
				cliente.getNombreCliente(), 
				cliente.getApellidoCliente(), 
				cliente.getTelefono(), 
				cliente.getDireccion(), 
				cliente.getCorreo()
		);
	}
	
	@Transactional
	public void actualizarCliente(Cliente cliente) {
		repo.actualizarCliente(
				cliente.getIdCliente(), // Asumiendo que tu entidad Cliente tiene el método getId()
				cliente.getDni(), 
				cliente.getNombreCliente(), 
				cliente.getApellidoCliente(), 
				cliente.getTelefono(), 
				cliente.getDireccion(), 
				cliente.getCorreo()
		);
	}
	
	@Transactional
	public void eliminarCliente(Integer id) {
		repo.eliminarCliente(id);
	}
	
}