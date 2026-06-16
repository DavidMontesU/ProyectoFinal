package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ControlDeCitas.model.Cliente;
import com.example.ControlDeCitas.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/lista")
	public String Listar (Model model) {
		List<Cliente> clientes = clienteService.listarTodos();
		model.addAttribute("dataCliente", clientes);
		model.addAttribute("cantReg", clientes.size());
		model.addAttribute("titulo", "Lista completa de clientes");
		return "cliente/clienteList";
	}
	
}
