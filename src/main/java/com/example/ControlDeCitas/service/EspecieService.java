package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.Especie;
import com.example.ControlDeCitas.repository.EspecieRepository;

public class EspecieService {
	@Autowired
	private EspecieRepository repo;

	@Transactional(readOnly = true)
	public List<Especie> listarTodas() {
		return repo.listarEspecies();
	}
}
