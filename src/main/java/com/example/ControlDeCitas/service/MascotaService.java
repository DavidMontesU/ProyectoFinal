package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.Mascota;
import com.example.ControlDeCitas.repository.MascotaRepository;

@Service
public class MascotaService {
	
	@Autowired
	MascotaRepository repo;
	
	@Transactional(readOnly = true)
	public List<Mascota> listarTodos() {
		return repo.listarMascotas();
	}

	@Transactional(readOnly = true)
	public Mascota obtenerMascota(Integer id) {
		return repo.obtenerMascota(id);
	}

	@Transactional
	public void registrarMascota(Mascota mascota) {
		repo.registrarMascota(
			mascota.getNombreMascota(),
			mascota.getIdEspecie(),
			mascota.getRaza(),
			mascota.getEdad(),
			mascota.getPeso(),
			mascota.getIdCliente(),
			mascota.getObservaciones()
		);
	}

	@Transactional
	public void actualizarMascota(Mascota mascota) {
		repo.actualizarMascota(
			mascota.getIdMascota(),
			mascota.getNombreMascota(),
			mascota.getIdEspecie(),
			mascota.getRaza(),
			mascota.getEdad(),
			mascota.getPeso(),
			mascota.getIdCliente(),
			mascota.getObservaciones()
		);
	}

	@Transactional
	public void eliminarMascota(Integer id) {
		repo.eliminarMascota(id);
	}

	@Transactional(readOnly = true)
	public List<Mascota> buscarMascotaByNombre(String nombre) {
		return repo.buscarMascotaByNombre(nombre);
	}

}
