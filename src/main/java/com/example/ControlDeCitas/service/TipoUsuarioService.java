package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.TipoUsuario;
import com.example.ControlDeCitas.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

	
	@Autowired
	private TipoUsuarioRepository repo;
	
	@Transactional(readOnly = true)
	public List<TipoUsuario> listarTodos() {
		return repo.findAll();
	}
}
