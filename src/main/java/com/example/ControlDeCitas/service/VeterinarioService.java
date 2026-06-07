package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ControlDeCitas.model.Veterinario;
import com.example.ControlDeCitas.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	VeterinarioRepository repo;
	
	public List<Veterinario> listarTodos() {
		return repo.listarVeterinarios();
	}
}
