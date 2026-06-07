package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.Cita;
import com.example.ControlDeCitas.repository.CitaRepository;

@Service
public class CitaService {
	@Autowired
	private CitaRepository repo;

	@Transactional(readOnly = true)
	public List<Cita> listarTodos() {
		return repo.llamarSpListarCitas();
	}
	
	@Transactional
	public void registrarCita (Cita cita) {
		repo.registrarCita(cita.getIdMascota(), cita.getIdVet(), cita.getIdTipoServicio(), cita.getFechaCita(), cita.getHoraCita(), cita.getMotivo(), cita.getObservaciones());
	}
	
	@Transactional
	public void actualizarCita(Cita cita) {
		repo.actualizarCita(cita.getIdCita(), cita.getIdMascota(), cita.getIdVet(), cita.getIdTipoServicio(), cita.getFechaCita(), cita.getHoraCita(), cita.getMotivo(), cita.getEstado(), cita.getObservaciones());
	}
	
	@Transactional
	public Cita obtenerCita(int id) {
		return repo.obtenerCita(id);
	}

	@Transactional
	public void eliminarCita(int id) {
		repo.eliminarCita(id);
	}
	
	@Transactional
	public List<Cita> obtenerCitaPorFecha(String fecha) {
		return repo.buscarCitaPorFecha(fecha);
	}
}
