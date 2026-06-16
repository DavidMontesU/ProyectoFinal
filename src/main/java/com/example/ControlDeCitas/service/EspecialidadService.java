package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.Especialidad;
import com.example.ControlDeCitas.repository.EspecialidadRepository;

@Service
public class EspecialidadService {

	@Autowired
	private EspecialidadRepository repo;

	@Transactional(readOnly = true)
	public List<Especialidad> listarTodas() {
		return repo.listarEspecialidades();
	}

}