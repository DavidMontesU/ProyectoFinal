package com.example.ControlDeCitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.Veterinario;
import com.example.ControlDeCitas.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository repo;

	// --- LECTURAS ---
	
	@Transactional(readOnly = true)
	public List<Veterinario> listarTodos() {
		return repo.listarVeterinarios();
	}
	
	
	@Transactional(readOnly = true)
	public Optional<Veterinario> obtenerPorId(Integer id) {
		return repo.obtenerVeterinarioPorId(id);
	}
	
	
	
	@Transactional(readOnly = true)
	public List<Veterinario> buscarPorNombre(String nombre) {
		return repo.buscarVeterinariosPorNombre(nombre);
	}

	// --- ESCRITURAS ---
	
	@Transactional
	public void registrarVeterinario(Veterinario veterinario) {
		repo.registrarVeterinario(
				veterinario.getCodVet(),
				veterinario.getNombreVet(),
				veterinario.getCodEsp(),
				veterinario.getTelefono(),
				veterinario.getEdad(),
				veterinario.getCorreo()
		);
	}
	
	
	@Transactional
	public void actualizarVeterinario(Veterinario veterinario) {
		repo.actualizarVeterinario(
				veterinario.getIdVet(), 
				veterinario.getCodVet(),
				veterinario.getNombreVet(),
				veterinario.getCodEsp(),
				veterinario.getTelefono(),
				veterinario.getEdad(),
				veterinario.getCorreo()
		);
	}
	
	@Transactional
	public void eliminarVeterinario(Integer id) {
		repo.eliminarVeterinario(id);
	}
	
}