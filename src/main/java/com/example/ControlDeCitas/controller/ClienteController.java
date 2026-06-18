package com.example.ControlDeCitas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ControlDeCitas.model.Cliente;
import com.example.ControlDeCitas.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/lista")
	public String listar(Model model) {
		List<Cliente> clientes = clienteService.listarTodos();
		model.addAttribute("dataCliente", clientes);
		model.addAttribute("cantReg", clientes.size());
		model.addAttribute("titulo", "Lista completa de clientes");
		model.addAttribute("content", "cliente/clienteList");
		return "layout";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("clienteDataEdit", new Cliente());
		model.addAttribute("titulo", "Registrar Cliente");
		model.addAttribute("content", "cliente/clienteNuevo");
		return "layout";
	}

	@PostMapping("/registrar")
	public String guardar(@ModelAttribute("clienteDataEdit") Cliente cliente, Model model, RedirectAttributes ra) {
		try {
			if (cliente.getIdCliente() != null && cliente.getIdCliente() > 0) {
				clienteService.actualizarCliente(cliente);
			} else {
				clienteService.registrarCliente(cliente);
			}
			ra.addFlashAttribute("msgExito", "Cliente guardado correctamente.");
			return "redirect:/clientes/lista";
		} catch (Exception e) {
			model.addAttribute("msgError", e.getMessage());
			model.addAttribute("clienteDataEdit", cliente);
			model.addAttribute("content", (cliente.getIdCliente() != null && cliente.getIdCliente() > 0) ? "cliente/clienteEdit" : "cliente/clienteNuevo");
			return "layout";
		}
	}

	@GetMapping("/infoEdit/{id}")
	public String obtenerEdit(@PathVariable("id") Integer id, Model model) {
		Optional<Cliente> cliente = clienteService.obtenerPorId(id);
		if(cliente.isPresent()) {
			model.addAttribute("clienteDataEdit", cliente.get());
		}
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("content", "cliente/clienteEdit");
		return "layout";
	}

	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") Integer id, Model model) {
		Optional<Cliente> cliente = clienteService.obtenerPorId(id);
		if(cliente.isPresent()) {
			model.addAttribute("clienteData", cliente.get());
		}
		model.addAttribute("titulo", "Información del Cliente");
		model.addAttribute("content", "cliente/clienteInfo");
		return "layout";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam("id") Integer id) {
		clienteService.eliminarCliente(id);
		return "redirect:/clientes/lista";
	}

	@PostMapping("/buscar")
	public String buscar(@RequestParam("txtBuscar") String txtBuscar, Model model) {
		// Asuming we filter the list in memory if there's no sp_buscarCliente, or we can fetch all and filter.
		// Since we don't have buscarCliente en el service, I'll filter the list
		List<Cliente> clientes = clienteService.listarTodos().stream()
			.filter(c -> c.getDni().contains(txtBuscar) || c.getNombreCliente().toLowerCase().contains(txtBuscar.toLowerCase()))
			.toList();
		
		model.addAttribute("dataCliente", clientes);
		model.addAttribute("cantReg", clientes.size());
		model.addAttribute("titulo", "Lista completa de clientes");
		model.addAttribute("content", "cliente/clienteList");
		return "layout";
	}
}
