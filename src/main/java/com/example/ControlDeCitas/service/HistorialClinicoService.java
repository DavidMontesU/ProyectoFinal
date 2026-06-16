package com.example.ControlDeCitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.HistorialClinico;
import com.example.ControlDeCitas.repository.HistorialClinicoRepository;

@Service
public class HistorialClinicoService {

	@Autowired
	private HistorialClinicoRepository repo;
	
	@Transactional(readOnly = true)
	public Optional<HistorialClinico> obtenerPorId(Integer idHistorial) {
		return repo.obtenerHistorialPorId(idHistorial);
	}

	@Transactional
	public void registrarHistorial(HistorialClinico historial) {
		
		Integer idDeLaCita = historial.getIdCita(); 

		repo.registrarHistorial(
				idDeLaCita, 
				historial.getDiagnostico(),
				historial.getTratamiento(),
				historial.getReceta(),
				historial.getProximaCita() // Como lo tienes como String en el modelo, lo pasamos como String
		);
	}
	
	@Transactional(readOnly = true)
	public List<HistorialClinico> obtenerPorMascota(Integer idMascota) {
		return repo.obtenerHistorialPorMascota(idMascota);
	}
	
}