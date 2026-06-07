package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ControlDeCitas.model.TipoServicio;
import com.example.ControlDeCitas.repository.TipoServicioRepository;

@Service
public class TipoServicioService {

	@Autowired
	TipoServicioRepository repo;
	
	public List<TipoServicio> listarTodos() {
		return repo.listarTiposServicios();
	}
}
