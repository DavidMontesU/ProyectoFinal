package com.example.ControlDeCitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ControlDeCitas.model.Cliente;
import com.example.ControlDeCitas.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;

	
	@Transactional(readOnly = true)
	public List<Cliente> listarTodos() {
		return repo.listarClientes();
	}
}
