package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ControlDeCitas.model.Mascota;
import com.example.ControlDeCitas.repository.MascotaRepository;

@Service
public class MascotaService {
	
	@Autowired
	MascotaRepository repo;
	
	public List<Mascota> listarTodos() {
		return repo.listarMascotas();
	}

}
